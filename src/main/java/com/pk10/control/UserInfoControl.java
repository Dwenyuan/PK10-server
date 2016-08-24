package com.pk10.control;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.pk10.bean.TokenConfig;
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

	@Autowired
	private TokenConfig tokenConfig;

	/**
	 * 获取用户信息 在1.0 版本中直接从session中获取
	 * 
	 * @param userInfo
	 * @return
	 */
	@RequestMapping(value = "getuserinfo", method = RequestMethod.POST)
	@ResponseBody
	public Object getUserInfo(@RequestBody UserInfo userInfo, HttpServletRequest request) {
		try {
			return request.getSession().getAttribute("userinfo");
			// return userInfoService.getOneById(userInfo);
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
			return JSON.parse("{errmsg:" + e.getMessage() + "}");
		}
	}

	@RequestMapping("register")
	@ResponseBody
	public Object register(@RequestBody UserInfo userInfo) {
		try {
			UserInfo safeUserInfo = userInfoService.getUserInfoByUsername(userInfo);
			if (safeUserInfo != null) { // 账号已经占用
				return false;
			} else {
				userInfo.setCreatedAt(new Date());
				userInfo.setMoney(tokenConfig.getMoney());
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

	@RequestMapping("checkTel")
	@ResponseBody
	public Object checkTel(String tel) {
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
				return "redirect:index.html";
			} else {
				return false;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
	}
}
