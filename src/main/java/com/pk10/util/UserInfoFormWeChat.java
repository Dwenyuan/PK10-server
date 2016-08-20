package com.pk10.util;

import java.io.IOException;
import java.util.Date;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pk10.bean.TokenConfig;
import com.pk10.bean.UserInfo;
import com.sina.sae.fetchurl.SaeFetchurl;

/**
 * 从微信获取用户数据相关
 * 
 * @author Administrator
 *
 */
@Component
public class UserInfoFormWeChat {

	private static final Logger logger = LoggerFactory.getLogger(UserInfoFormWeChat.class);

	@Autowired
	private TokenConfig tokenConfig;

	public UserInfo getUserInfoFromWechat(String code) throws ClientProtocolException, IOException {
		String codeToOpenid = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + tokenConfig.getAppID() + "&secret=" + tokenConfig.getAppsecret() + "&code=" + code
				+ "&grant_type=authorization_code";
		String openidStr = new SaeFetchurl().fetch(codeToOpenid);
		logger.info("get openid URL ===> " + codeToOpenid);
		JSONObject openidInfo = JSON.parseObject(openidStr);
		logger.error("get openid data ===>   " + openidStr);
		String getUserInfo = "https://api.weixin.qq.com/sns/userinfo?access_token=" + openidInfo.get("access_token") + "&openid=" + openidInfo.get("openid") + "&lang=zh_CN";
		String userinfo = new SaeFetchurl().fetch(getUserInfo);
		// 解决读取乱码的问题
		userinfo = new String(userinfo.getBytes("ISO-8859-1"), "utf-8");
		logger.error("get user info ===>" + userinfo);
		JSONObject userInfoObj = JSON.parseObject(userinfo);
		return new UserInfo(userInfoObj.getString("openid"), userInfoObj.getString("nickname"), userInfoObj.getString("headimgurl"), null, new Date());
	}
}
