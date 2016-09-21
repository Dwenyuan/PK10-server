package com.pk10.control;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pk10.bean.*;
import com.pk10.service.BetInitService;
import com.pk10.service.MoneyAddRecordService;
import com.pk10.service.UserInfoService;
import com.pk10.util.Const;
import com.pk10.util.UserInfoFormWeChat;
import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.pk10.util.Const.ERROR_MSG;

/**
 * 获取用户信息
 *
 * @author Administrator
 *
 */
@SessionAttributes("captcha")
@Controller
@Scope("prototype")
public class UserInfoControl {

    private static final Logger logger = LoggerFactory.getLogger(UserInfoControl.class);

    @Autowired
	private UserInfoService userInfoService;

    @Autowired
    MoneyAddRecordService moneyAddRecordService;

	@Autowired
	private UserInfoFormWeChat userInfoFormWeChat;

	@Autowired
	private TokenConfig tokenConfig;

	@Autowired
	private BetInitService betInitService;

    @RequestMapping("/money-manager")
    public String moneyManager() {
        return "admin/money";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUserInfoById(@RequestParam("username")String username, Model model) throws Exception {
    	UserInfo muserInfo = new UserInfo();
		muserInfo.setUsername(username);
        UserInfo userInfo = userInfoService.getUserInfoByUsername(muserInfo);
        if (userInfo.getUsername() == null) {
            model.addAttribute(ERROR_MSG, "未找到指定的用户信息!");
        } else {
            model.addAttribute("user", userInfo);
        }
        return "admin/money";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String updateUserInfo(HttpServletRequest request,
                                 @RequestParam("id")int id,
                                 @RequestParam(value = "charge_money", required = false)Double chargeMoney,
								 @ModelAttribute UserInfo user) throws Exception {
        UserInfo userInfo = userInfoService.getOneById(new UserInfo(id));
		if (chargeMoney != null) {
			double money = userInfo.getMoney() + chargeMoney;
			userInfo.setMoney(money);
            userInfoService.update(userInfo);
			// 添加充值记录
			UserInfo sessionUser = (UserInfo) request.getSession().getAttribute("userinfo");
			MoneyAddRecord moneyAddRecord = new MoneyAddRecord();
            moneyAddRecord.setUserId(userInfo.getId());
			moneyAddRecord.setUserName(userInfo.getUsername());
			moneyAddRecord.setAddMoney(chargeMoney);
			moneyAddRecord.setAddAgentName(sessionUser.getUsername());
            moneyAddRecord.setAddAgentId(sessionUser.getId());
            moneyAddRecord.setAddTime(new Date());
			moneyAddRecordService.save(moneyAddRecord);
        } else {

            userInfo.setUsername(user.getUsername());
            userInfo.setPassword(user.getPassword());
            userInfo.setTel(user.getTel());
            userInfo.setIsagent(user.getIsagent());
            userInfoService.update(user);
        }

        return "redirect:users";
    }

	/**
	 * 获取用户信息 在1.0 版本中直接从session中获取
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "getuserinfo", method = RequestMethod.POST)
	@ResponseBody
	public Object getUserInfo(HttpServletRequest request) {
		try {
			return request.getSession().getAttribute("userinfo");
			// return userInfoService.getOneById(userInfo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String getUserInfoList(Model model, @RequestParam(value = "pn", required = false)Integer pn) {
		try {
		    if (pn == null || pn <= 0)
		        pn = 1;

            PageHelper.startPage(pn, 10);
			List<UserInfo> users =  userInfoService.getAll();
            if (users == null) {
                model.addAttribute(ERROR_MSG, "用户列表为空!");
            } else {
                PageInfo page = new PageInfo(users);
                if (page.getPageNum() > 0) {
                    model.addAttribute("users", users);
                    model.addAttribute("page", page);
                    model.addAttribute("pn", pn);
                }
            }

		} catch (Exception e) {
		    model.addAttribute(ERROR_MSG, e.getMessage());
			logger.error(e.getMessage());
		}

		return "admin/userlist";
	}

	@RequestMapping(value = "updateuserinfo", method = RequestMethod.POST)
	@ResponseBody
	public Object updateUserInfo(@RequestBody UserInfo userInfo, HttpServletRequest request) {
		try {
			Integer update = userInfoService.update(userInfo);
			if (update > 0) {
				request.getSession().setAttribute("userinfo", userInfo);
			}
			return update;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
	}


	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @ResponseBody
	public Map deleteUser(@PathVariable("id")Integer id) throws Exception {
        Map map = new HashMap();
	    Integer affect = userInfoService.deleteOneById(new UserInfo(id));
        if (affect != null)
            map.put(Const.SUCCESS_MSG, "删除成功!");
        else
            map.put(Const.ERROR_MSG, "删除失败!");

        return map;
    }

    @RequestMapping(value = "/isagent/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map getAgents(@PathVariable("id")Integer id) throws Exception {
        Map map = new HashMap();

        List<UserInfo> agents = userInfoService.getAgentsById(id);
        if (agents != null && agents.size() > 0)
            map.put("agents", agents);
        else
            map.put(Const.ERROR_MSG, "获取失败!");

        return map;
    }

    @RequestMapping(value = "/owner/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map getAgentsByOwnerId(@PathVariable("id")Integer id) throws Exception {
        Map map = new HashMap();

        List<UserInfo> ownersOfAgents = userInfoService.getAgentsByOwnerId(id);
        if (ownersOfAgents != null && ownersOfAgents.size() > 0)
            map.put("ownersOfAgents", ownersOfAgents);
        else
            map.put(Const.ERROR_MSG, "获取失败!");

        return map;
    }

    @RequestMapping(value = "/{username}/agent/{isagent}", method = RequestMethod.GET)
    public String getUsersByAgentId(Model model, @PathVariable("username")String username,
                                           @PathVariable("isagent")Integer isagent) throws Exception {

        List<UserInfo> users = userInfoService.getUsersByAgentId(username, isagent);
        if (users != null && users.size() > 0)
            model.addAttribute("users", users);
        else
            model.addAttribute(Const.ERROR_MSG, "获取失败,没有对应用户名!");

        return "admin/userlist";
    }

    @RequestMapping(value = "/junior/users/{owner}", method = RequestMethod.GET)
    public String getJuniorUsersForAgent(Model model, @PathVariable("owner")Integer owner) {
        UserInfo ownerUser = new UserInfo();
        ownerUser.setOwner(owner);
        List<UserInfo> juniorUsers = userInfoService.getUserForAgent(ownerUser);
        if (juniorUsers != null && juniorUsers.size() > 0)
            model.addAttribute("users", juniorUsers);
        else
            model.addAttribute(Const.ERROR_MSG, "当前用户无下级用户列表!");

        return "admin/junior-userlist";
    }

    @RequestMapping(value = "/reg-user", method = RequestMethod.POST)
    public String register(ModelMap map, @ModelAttribute UserInfo userInfo, String code) {
        if (userInfo == null) {
            map.addAttribute("error_response", "无效参数!");
        } else {
            try {
                if (map.get("captcha").equals(code)) {
                    userInfo.setIsagent(0);
                    userInfo.setCreatedAt(new Date());
                    userInfo.setNickname(userInfo.getUsername());
                    userInfoService.save(userInfo);
                    map.addAttribute("success_response", "注册成功!");
                } else {
                    map.addAttribute("error_response", "验证码失效,请稍后重试!");
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
                map.addAttribute("error_response", "服务器异常,请稍后重试!");
            }
        }
        return "admin/register";
    }

	@RequestMapping(value = "/reg-ui/{owner}", method = RequestMethod.GET)
	public String registerUI(ModelMap map, @PathVariable("owner")Integer owner) {
	    map.addAttribute("owner", owner);
		return "admin/register";
	}

	/**
	 * 获取微信传过来的code，此code用来获取用户的openid
	 *
	 */
	@RequestMapping("getUserCode")
	@ResponseBody
	public Object getUserCode(String code, String state, HttpServletRequest request) {
		UserInfo userinfo = null;
		try {
			// 如果session 中没有保存用户信息，则重新从微信服务器读取
			userinfo = (UserInfo) request.getSession().getAttribute("userinfo");
			logger.info("get userinfo by code ====> code :" + code);
			if (userinfo == null) {
				userinfo = userInfoFormWeChat.getUserInfoFromWechat(code);
				if (userinfo != null && userinfo.getOpenid() != null) { // 用户信息中openid为空，说明获取信息失败了，不添加到session中，刷新后重新获取
					request.getSession().setAttribute("userinfo", userinfo);
				}
			}
			logger.info(userinfo.toString());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userinfo;
	}

	@RequestMapping("cashPrize")
	@ResponseBody
	public Object cashPrize(@RequestBody UserInfo userInfo, HttpServletRequest request) {
		try {
			UserInfo safeUserInfo = userInfoService.cashPrize(userInfo);
			if (safeUserInfo != null) {
				// 兑奖后更新 session 中的用户
				request.getSession().setAttribute("userinfo", safeUserInfo);
			}
			return safeUserInfo;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return JSON.parse("{\"errmsg\":" + e.getMessage() + "}");
		}
	}

	@RequestMapping("register")
	@ResponseBody
	public Object register(@RequestBody UserInfo userInfo) {
		try {
			UserInfo safeUserInfo = userInfoService.getUserInfoByUsername(userInfo);
			// TODO 等待添加游戏类型设定
			BetInit safeBetInit = betInitService.getOneBetInitByName(new BetInit("PK10"));
			if (safeUserInfo != null) { // 账号已经占用
				return false;
			} else {
				userInfo.setCreatedAt(new Date());
				userInfo.setMoney(safeBetInit.getInitMoney() + 0.0);
				Integer save = userInfoService.save(userInfo);
				if (save > 0) { // 保存成功
					return true;
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
		return userInfo;
	}

	@RequestMapping("check-tel/{tel}")
	@ResponseBody
	public Object checkTel(@PathVariable("tel")String tel) {
		UserInfo safeUserInfo = userInfoService.getUserInfoByTel(new UserInfo(null, null, tel));
		if (safeUserInfo != null) { // 查找到记录，表示已经占用
			return false;
		} else {
			return true;
		}
	}

	@RequestMapping("checkusername")
	@ResponseBody
	public Object checkusername(String username) {
	    logger.debug("checkusername: username = " + username);
		UserInfo safeUserInfo = userInfoService.getUserInfoByUsername(new UserInfo(username, null));
		if (safeUserInfo != null) {
			return false; // 用户名占用
		} else {
			return true;
		}
	}

	@RequestMapping("login")
	@ResponseBody
	public Object login(@RequestBody UserInfo userInfo, HttpServletRequest request) {
		UserInfo safeUserinfo;
		try {
			safeUserinfo = userInfoService.login(userInfo);
			if (safeUserinfo != null) {
				request.getSession().setAttribute("userinfo", safeUserinfo);
				return "redirect:index.jsp";
			} else {
				return false;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
	}
	@RequestMapping("logout")
	@ResponseBody
	public Object logout(HttpServletRequest request) {
		try {
			request.getSession().setAttribute("userinfo", null);
			return "redirect:userlogin.html";
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
	}
	@RequestMapping(value = "managerlogin", method = RequestMethod.POST)
	public Object managerLogin(@ModelAttribute UserInfo userInfo, HttpServletRequest request) {
		UserInfo safeUserinfo;
		try {
			safeUserinfo = userInfoService.managerLogin(userInfo);
			if (safeUserinfo != null) {
				request.getSession().setAttribute("userinfo", safeUserinfo);
				return "redirect:manager.html";
			} else {
				return "redirect:managerlogin.html";
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return "redirect:managerlogin.html";
		}
	}


	@RequestMapping(value = "adminlogin", method = RequestMethod.POST)
	public Object adminlogin(@ModelAttribute UserInfo userInfo, HttpServletRequest request) {
		UserInfo safeUserinfo;
		try {
			safeUserinfo = userInfoService.managerLogin(userInfo);
			if (safeUserinfo != null) {
				request.getSession().setAttribute("userinfo", safeUserinfo);
				if(safeUserinfo.getIsagent() == 3){
					return "admin/admin-index";
				}else{
					return "admin/admin-agent";
				}
			} else {
				return "redirect:admin-login.htm";
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return "redirect:admin-login.htm";
		}
	}

	@RequestMapping("adminloginout")
	public Object adminloginout(HttpServletRequest request) {
		UserInfo safeUserinfo;
		try {
			request.getSession().removeAttribute("userinfo");
			return "redirect:admin-login.htm";
		} catch (Exception e) {
			logger.error(e.getMessage());
			return "redirect:admin-login.htm";
		}
	}

	// 通过ID获取代理商
	@RequestMapping("getAgentById")
	@ResponseBody
	public Object getAgentById(@RequestBody AgentInfo agentInfo) {
		try {
			return userInfoService.getAgentById(agentInfo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
	}

	// 获取代理商名下所有用户
	@RequestMapping(value = "getUserForAgent", method = RequestMethod.POST)
	@ResponseBody
	public Object getUserForAgent(@RequestBody UserInfo userInfo) {
		try {
			return userInfoService.getUserForAgent(userInfo);
		} catch (Exception e) {
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
	}

	// 注册代理商
	@RequestMapping("registerAgent")
	@ResponseBody
	public Object registerAgent(@RequestBody AgentInfo agentInfo) {
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername(agentInfo.getUsername());
		try {
			UserInfo hasExitUser = userInfoService.getUserInfoByUsername(userInfo);
			if (hasExitUser != null) {
				return false;
			} else {
				agentInfo.setCreatedAt(new Date());
				Integer save = userInfoService.savaAgent(agentInfo);
				if (save > 0) {
					return true;
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
		return agentInfo;
	}

	@RequestMapping("registerDistributor")
	@ResponseBody
	public Object registerDistributor(@RequestBody UserModel userModel) {
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername(userModel.getUsername());
		try {
			UserInfo hasExitUser = userInfoService.getUserInfoByUsername(userInfo);
			if (hasExitUser != null) {
				return false;
			} else {
				userInfo.setCreatedAt(new Date());
				userInfo.setNickname(userModel.getNickname());
				userInfo.setUsername(userModel.getUsername());
				userInfo.setPassword(userModel.getPassword());
				userInfo.setTel(userModel.getTel());
				userInfo.setRebate(userModel.getRebate());
				userInfo.setDetail(userModel.getDetail());
				userInfo.setIsagent(userModel.getIsagent());
				UserInfo m = new UserInfo();
				if(userModel.getAgentId() == ""||userModel.getAgentId() == null){
					userInfo.setOwner(0);
				}else{
					m.setUsername(userModel.getAgentId());
					userInfo.setOwner((userInfoService.getUserInfoByUsername(m).getId()));
				}
				Integer save = userInfoService.save(userInfo);
				if (save > 0) {
					return true;
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
		return userModel;
	}


	// 修改代理商信息
	@RequestMapping("updateAgentInfo")
	@ResponseBody
	public Object updateAgentInfo(@RequestBody AgentInfo agentInfo, HttpServletRequest request) {
		try {
			Integer update = userInfoService.updateAgent(agentInfo);
			if (update > 0) {
				request.getSession().setAttribute("Agentinfo", agentInfo);
			}
			return update;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
	}

	@RequestMapping("toAddAgent")
	public Object toAddAgent(){
		return "admin/add_agent";
	}
    //增加普通用户
	@RequestMapping("toAddDistributor")
	public Object toAddDistributor(Model model,HttpServletRequest request){
		model.addAttribute("userinfo",request.getSession().getAttribute("userinfo"));
		return "admin/add_distributor";
	}

	@RequestMapping("toAgentList")
	public Object toAgentList(Model model, Page page){

		try {
			if (page.getPages() == 0) {
				page.setPages(1);
				AgentInfo agentInfo = new AgentInfo();
				agentInfo.setIsagent(2);
				Datagrid agentDatagrid = userInfoService.getAllAgent(page,agentInfo);
				model.addAttribute("agentDatagrid",agentDatagrid);
				return "admin/agentlist";
			}else {
				AgentInfo agentInfo = new AgentInfo();
				agentInfo.setIsagent(2);
				Datagrid agentDatagrid = userInfoService.getAllAgent(page,agentInfo);
				model.addAttribute("agentDatagrid",agentDatagrid);
				return "admin/agentlist";
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
	}

	@RequestMapping("toSuperList")
	public Object toSuperList(Model model, Page page){

		try {
			if (page.getPages() == 0) {
				page.setPages(1);
				AgentInfo agentInfo = new AgentInfo();
				agentInfo.setIsagent(3);
				Datagrid superDatagrid = userInfoService.getAllAgent(page,agentInfo);
				model.addAttribute("superDatagrid",superDatagrid);
				return "admin/superuserlist";
			}else {
				AgentInfo agentInfo = new AgentInfo();
				agentInfo.setIsagent(3);
				Datagrid agentDatagrid = userInfoService.getAllAgent(page,agentInfo);
				model.addAttribute("superDatagrid",agentDatagrid);
				return "admin/superuserlist";
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
	}


	@RequestMapping("deleteAgent")
	@ResponseBody
	public Object deleteAgent(@RequestBody UserInfo userInfo){
		try {
			return userInfoService.deleteOneById(userInfo);
		} catch (Exception e) {
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
	}

	@RequestMapping("getUserByUsername")
	@ResponseBody
	public UserInfo getUserByUsername(@RequestBody UserInfo userInfo){
		return userInfoService.getUserUsername(userInfo);
	}

}
