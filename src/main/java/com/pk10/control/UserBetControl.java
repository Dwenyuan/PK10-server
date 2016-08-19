package com.pk10.control;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.pk10.bean.UserBet;
import com.pk10.bean.UserInfo;
import com.pk10.service.UserBetService;

@Controller
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
}
