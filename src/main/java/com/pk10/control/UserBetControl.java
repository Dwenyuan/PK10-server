package com.pk10.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSON;
import com.pk10.bean.UserBet;
import com.pk10.bean.UserInfo;
import com.pk10.service.UserBetService;

@Controller
@RequestMapping("userbet")
public class UserBetControl {
	private static final Logger logger = LoggerFactory.getLogger(UserBetControl.class);

	@Autowired
	private UserBetService userBetService;

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
	public Object createUserBets(@RequestBody List<UserBet> userBets) {
		try {
			return userBetService.saveList(userBets);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
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
	public Object getRecentlyBets(Integer num) {
		try {
			return userBetService.getRecentlyBets(num);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
	}

	@RequestMapping("/list")
	@ResponseBody
	public String getBetsByUserId(@RequestParam("id")int id) {
		Map<String, Object> map = new HashMap<>();
		List<UserBet> userBets = userBetService.getBetsByUserId(id);
		map.put("userbets", userBets);
		return JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd HH:mm:ss");
	}
}
