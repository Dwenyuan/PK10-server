package com.pk10.control;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pk10.bean.UserBet;
import com.pk10.bean.UserInfo;
import com.pk10.service.UserBetService;
import com.pk10.service.UserInfoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

import static com.pk10.util.Const.ERROR_MSG;

@Controller
@RequestMapping("userbet")
public class UserBetControl {
	private static final Logger logger = LoggerFactory.getLogger(UserBetControl.class);

	@Autowired
	private UserBetService userBetService;
	
	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping(value = "createUserBet", method = RequestMethod.POST)
	@ResponseBody
	public Object createUserBet(@RequestBody UserBet userBet) {
		try {
			return userBetService.save(userBet);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
	}

	@RequestMapping(value = "createUserBets", method = RequestMethod.POST)
	@ResponseBody
	public Object createUserBets(@RequestBody List<UserBet> userBets, HttpSession session) {
		try {
			session.setAttribute("userBets", userBets);
			Integer saveList = userBetService.saveList(mergebets(userBets));
			if (saveList != null && saveList > 0) {
				session.setAttribute("userinfo", userInfoService.getOneById((UserInfo)session.getAttribute("userinfo")));
			}
			return saveList;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
	}

	public static List<UserBet> mergebets(List<UserBet> userBets) {
		List<UserBet> result = new ArrayList<UserBet>();
		UserBet temp = null;
		try {
			for (UserBet userBet : userBets) {
				if (result.size() == 0) {
					result.add(userBet.clone());
				} else {
					for (UserBet value : result) {
						if (checkEqule(userBet, value)) {
							temp = value;
						}
					}
					if (temp != null) {
						temp.setBetmoney(temp.getBetmoney() + userBet.getBetmoney());
						temp = null;
					} else {
						result.add(userBet.clone());
					}
				}
			}
			return result;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	public static boolean checkEqule(UserBet key1, UserBet key2) {
		if (key1.getUserid().equals(key2.getUserid()) && key1.getBetnum().equals(key2.getBetnum())
				&& key1.getIdnum().equals(key2.getIdnum()) && key1.getType().equals(key2.getType())) {
			return true;
		} else {
			return false;
		}
	}

	@RequestMapping("getUserBetByOpenid")
	@ResponseBody
	public Object getUserBetByOpenid(UserInfo userInfo) {
		try {
			return userBetService.getUserBetByOpenid(userInfo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
	}

	@RequestMapping("getRecentlyBets")
	@ResponseBody
	public Object getRecentlyBets(Integer num, HttpSession session) {
		try {
			UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
			return userBetService.getRecentlyBets(userInfo.getId(), num);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
	}

	/**
	 * 获取最近一期下注，并且未开奖
	 * 
	 * @return
	 */
	@RequestMapping("getlastBets")
	@ResponseBody
	public Object getlastBets(HttpSession session) {
		try {
			Object userbets = session.getAttribute("userBets");
			return userbets == null ? new ArrayList<Object>() : userbets;
			// return
			// userBetService.getlastBets(session.getAttribute("userBets"));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
	}

	@RequestMapping("/list")
	@ResponseBody
	public String getBetsByUserId(@RequestParam("id") int id) {
		Map<String, Object> map = new HashMap<>();
		List<UserBet> userBets = userBetService.getBetsByUserId(id);
		map.put("userbets", userBets);
		return JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd HH:mm:ss");
	}

	@RequestMapping(value = "/bets", method = RequestMethod.GET)
	public String getBetList(Model model, @RequestParam(value = "pn", required = false) Integer pn) {
		try {
			if (pn == null || pn <= 0)
				pn = 1;

			PageHelper.startPage(pn, 10);
			List<UserBet> bets = userBetService.getAll();
			if (bets.size() <= 0) {
				model.addAttribute(ERROR_MSG, "投注列表为空!");
			} else {
				PageInfo pageInfo = new PageInfo(bets);
				if (pageInfo.getPageNum() > 0) {
					model.addAttribute("bets", bets);
					model.addAttribute("page", pageInfo);
					model.addAttribute("pn", pn);
				}
			}

		} catch (Exception e) {
			model.addAttribute(ERROR_MSG, e.getMessage());
			logger.error(e.getMessage());
		}

		return "admin/bet-list";
	}

	@RequestMapping(value = "/{startIdnum}/{endIdnum}", method = RequestMethod.GET)
	public String getBetsByIdnum(Model model, @RequestParam(value = "pn", required = false) Integer pn,
                                 @PathVariable("startIdnum") Integer startIdnum,
                                 @PathVariable("endIdnum")Integer endIdnum) {
		try {
			if (pn == null || pn <= 0)
				pn = 1;

			PageHelper.startPage(pn, 10);
			List<UserBet> bets = userBetService.findByBetweenIdnum(0,startIdnum, endIdnum);
			if (bets.size() <= 0) {
				model.addAttribute(ERROR_MSG, "投注列表为空!");
			} else {
				PageInfo pageInfo = new PageInfo(bets);
				if (pageInfo.getPageNum() > 0) {
					model.addAttribute("bets", bets);
                    model.addAttribute("startIdnum", startIdnum);
                    model.addAttribute("endIdnum", endIdnum);
					model.addAttribute("page", pageInfo);
					model.addAttribute("pn", pn);
				}
			}

		} catch (Exception e) {
			model.addAttribute(ERROR_MSG, e.getMessage());
			logger.error(e.getMessage());
		}

		return "admin/bet-list";
	}
	@ResponseBody
	@RequestMapping(value = "/{uid}/{startIdnum}/{endIdnum}", method = RequestMethod.GET)
	public String getBetsByIdnumJson(Model model, @RequestParam(value = "pn", required = false) Integer pn,
								 @PathVariable("startIdnum") Integer startIdnum,
									 @PathVariable("uid") Integer uid,
								 @PathVariable("endIdnum")Integer endIdnum) {
		List<UserBet> bets= new ArrayList<>();

		try {
			if (pn == null || pn <= 0)
				pn = 1;

			PageHelper.startPage(pn, 10);
			bets = userBetService.findByBetweenIdnum(uid, startIdnum, endIdnum);
			if (bets.size() <= 0) {
				model.addAttribute(ERROR_MSG, "投注列表为空!");
			} else {
				PageInfo pageInfo = new PageInfo(bets);
				if (pageInfo.getPageNum() > 0) {
					model.addAttribute("bets", bets);

				}
			}

		} catch (Exception e) {
			model.addAttribute(ERROR_MSG, e.getMessage());
			logger.error(e.getMessage());
		}

		return JSON.toJSONStringWithDateFormat(bets, "yyyy-MM-dd HH:mm:ss");
	}


	/*
	代理商下级投注列表
	 */
	@RequestMapping(value = "junior/{curAgentId}/{startIdnum}/{endIdnum}", method = RequestMethod.GET)
	public String getBetsByIdnum(Model model, @PathVariable("curAgentId")Integer curAgentId,
								 @PathVariable("startIdnum") Integer startIdnum,
								 @PathVariable("endIdnum")Integer endIdnum,
								 @RequestParam(value = "pn", required = false) Integer pn) {
		try {
			if (pn == null || pn <= 0)
				pn = 1;

            List<UserBet> fromBetList = new LinkedList<>();
            List<UserBet> toBetList = new LinkedList<>();

			UserInfo ui = new UserInfo();
			ui.setOwner(curAgentId);
			List<UserInfo> users = userInfoService.getUsersForAgent(ui);
			List<UserBet> bets = null;
			for (UserInfo user : users) {
				bets = userBetService.findByBetweenIdnum(user.getId(), startIdnum, endIdnum);

                for (int i = 0; i < bets.size(); i++) {
                    fromBetList.add(bets.get(i));
                }
            }

            if (fromBetList.size() <= 0) {
                model.addAttribute(ERROR_MSG, "投注列表为空!");
            } else {
                com.github.pagehelper.Page<UserBet> page = new Page<>();
                page.addAll(fromBetList);
                PageInfo pageInfo = new PageInfo(page);
                pageInfo.setList(fromBetList);
                pageInfo.setPageNum(pn);
                pageInfo.setPageSize(10);
                pageInfo.setTotal(fromBetList.size());
                pageInfo.setFirstPage(pn);
                pageInfo.setPrePage(pn-1);
                if (fromBetList.size() / 10 == 0) {
                    pageInfo.setLastPage(fromBetList.size() / 10);
                    pageInfo.setPages(fromBetList.size() / 10);
                } else {
                    pageInfo.setLastPage(fromBetList.size() / 10 + 1);
                    pageInfo.setPages(fromBetList.size() / 10 + 1);
                }
                if (pn == 1) {
                    pageInfo.setIsFirstPage(true);
                } else {
                    pageInfo.setIsFirstPage(false);
                }

                if (pn == fromBetList.size() % 10) {
                    pageInfo.setIsLastPage(true);
                } else {
                    pageInfo.setIsLastPage(false);
                }

                if (pn - 1 > 0) {
                    pageInfo.setHasPreviousPage(true);
                } else {
                    pageInfo.setHasNextPage(false);
                }

                if (pn + 1 < fromBetList.size() % 10) {
                    pageInfo.setHasNextPage(true);
                } else {
                    pageInfo.setHasNextPage(false);
                }
                
                // 对betList分页
                int j;
                j = pn > 1 ? (pn - 1) * 10 : 0;
                for (int i = j, c = 0; i < fromBetList.size() && c < 10; i++, c++) {
                    toBetList.add(fromBetList.get(i));
                }

                model.addAttribute("bets", toBetList);
                model.addAttribute("startIdnum", startIdnum);
                model.addAttribute("endIdnum", endIdnum);
                model.addAttribute("page", pageInfo);
                model.addAttribute("pn", pn);
				
			}

		} catch (Exception e) {
			model.addAttribute(ERROR_MSG, e.getMessage());
			logger.error(e.getMessage());
		}

		return "admin/junior-bet-list";
	}
}

