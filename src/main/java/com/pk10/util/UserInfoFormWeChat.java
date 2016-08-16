package com.pk10.util;

import java.io.IOException;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pk10.bean.TokenConfig;
import com.sina.sae.fetchurl.SaeFetchurl;

/**
 * 从微信获取用户数据相关
 * 
 * @author Administrator
 *
 */
@Component
public class UserInfoFormWeChat {

	@Autowired
	private TokenConfig tokenConfig;

	public Map<String, Object> getUserInfoFromWechat(String code) throws ClientProtocolException, IOException {
		String codeToOpenid = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + tokenConfig.getAppID() + "&secret=" + tokenConfig.getAppsecret() + "&code="
				+ "031NzCda1QOagU1JJOda1izAda1NzCdH" + "&grant_type=authorization_code";
//		String userinfostr = Request.Get(url).execute().returnContent().asString();
		SaeFetchurl fetchurl = new SaeFetchurl();
		String openidStr = fetchurl.fetch(codeToOpenid);
		JSONObject openidInfo = JSON.parseObject(openidStr);
		String getUserInfo = "https://api.weixin.qq.com/sns/userinfo?access_token="+openidInfo.get("access_token")+"&openid="+openidInfo.get("openid")+"&lang=zh_CN";
		String userinfo = fetchurl.fetch(getUserInfo);
		return JSON.parseObject(new String(userinfo.getBytes(), "utf-8"));
	}
}
