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
import com.pk10.service.TokenConfigService;
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
	private TokenConfigService tokenConfigService;
	
	private TokenConfig tokenConfig;

	public UserInfo getUserInfoFromWechat(String code) throws ClientProtocolException, IOException {
		if (tokenConfig==null) {
			tokenConfig = tokenConfigService.getLastTokenConfig();
		}
		String codeToOpenid = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + tokenConfig.getAppID() + "&secret=" + tokenConfig.getAppsecret() + "&code=" + code
				+ "&grant_type=authorization_code";
		SaeFetchurl fetchurl = new SaeFetchurl();
		String openidStr = fetchurl.fetch(codeToOpenid);
		logger.error("error code ====> "+fetchurl.getErrno());
		logger.error("error code ====> "+fetchurl.getErrmsg());
		logger.info("get openid URL ===> " + codeToOpenid);
		JSONObject openidInfo = JSON.parseObject(openidStr);
		logger.info("get openid data ===>   " + openidStr);
		String getUserInfo = "https://api.weixin.qq.com/sns/userinfo?access_token=" + openidInfo.get("access_token") + "&openid=" + openidInfo.get("openid") + "&lang=zh_CN";
		String userinfo = new SaeFetchurl().fetch(getUserInfo);
		// 解决读取乱码的问题
		userinfo = new String(userinfo.getBytes("ISO-8859-1"), "utf-8");
		logger.info("get user info ===>" + userinfo);
		JSONObject userInfoObj = JSON.parseObject(userinfo);
		return new UserInfo(userInfoObj.getString("openid"), userInfoObj.getString("nickname"), userInfoObj.getString("headimgurl"), null, new Date());
	}
}
