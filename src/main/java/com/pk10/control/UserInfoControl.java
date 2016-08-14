package com.pk10.control;

import java.io.IOException;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.pk10.bean.UserInfo;
import com.pk10.service.UserInfoService;
import com.pk10.util.UserInfoFormWeChat;

/**
 * 获取用户信息
 * 
 * @author Administrator
 *
 */
@Controller
public class UserInfoControl {

	private static final Logger logger = LoggerFactory.getLogger(UserInfoControl.class);

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private UserInfoFormWeChat userInfoFormWeChat;

	@RequestMapping("getuserinfo")
	@ResponseBody
	public Object getUserInfo(@Param(value = "openid") String openid) {
		try {
			return userInfoService.getOneById(new UserInfo(openid));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
	}

	@RequestMapping(value = "updateuserinfo", method = RequestMethod.POST)
	@ResponseBody
	public Object updateUserInfo(@RequestBody UserInfo userInfo) {
		try {
			return userInfoService.update(userInfo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
	}

	@RequestMapping("getUserInfoList")
	@ResponseBody
	public Object getUserInfoList() {
		try {
			return userInfoService.getAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
	}

	/**
	 * 获取微信传过来的code，此code用来获取用户的openid
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("getUserCode")
	@ResponseBody
	public Object getUserCode(String code, String state) {
		Map<String, Object> userinfo = null;
		try {
			logger.error("code:" + code);
			userinfo = userInfoFormWeChat.getUserInfoFromWechat(code);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userinfo;
	}
}
