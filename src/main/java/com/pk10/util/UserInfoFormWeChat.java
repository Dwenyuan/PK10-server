package com.pk10.util;

import java.io.IOException;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
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
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + tokenConfig.getAppID() + "&secret=" + tokenConfig.getAppsecret() + "&code="
				+ code + "&grant_type=authorization_code";
//		String userinfostr = Request.Get(url).execute().returnContent().asString();
		String userinfostr = new SaeFetchurl().fetch(url);
		return JSON.parseObject(userinfostr);
	}
}
