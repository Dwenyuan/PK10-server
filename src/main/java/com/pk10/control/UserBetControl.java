package com.pk10.control;

import com.alibaba.fastjson.JSON;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
				PageInfo page = new PageInfo(bets);
				if (page.getPageNum() > 0) {
					model.addAttribute("bets", bets);
					model.addAttribute("page", page);
					model.addAttribute("pn", pn);
				}
			}

		} catch (Exception e) {
			model.addAttribute(ERROR_MSG, e.getMessage());
			logger.error(e.getMessage());
		}

		return "admin/bet-list";
	}

	@RequestMapping(value = "/{idnum}", method = RequestMethod.GET)
	public String getBetsByIdnum(Model model, @RequestParam(value = "pn", required = false) Integer pn,
			@PathVariable("idnum") Integer idnum) {
		try {
			if (pn == null || pn <= 0)
				pn = 1;

			PageHelper.startPage(pn, 10);
			List<UserBet> bets = userBetService.getBetsByIdnum(idnum);
			if (bets.size() <= 0) {
				model.addAttribute(ERROR_MSG, "投注列表为空!");
			} else {
				PageInfo page = new PageInfo(bets);
				if (page.getPageNum() > 0) {
					model.addAttribute("bets", bets);
					model.addAttribute("page", page);
					model.addAttribute("pn", pn);
				}
			}

		} catch (Exception e) {
			model.addAttribute(ERROR_MSG, e.getMessage());
			logger.error(e.getMessage());
		}

		return "admin/bet-list";
	}
}
