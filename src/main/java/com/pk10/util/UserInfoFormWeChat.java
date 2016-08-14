package com.pk10.util;

import java.io.IOException;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.pk10.bean.TokenConfig;

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
		String userinfostr = Request.Get("https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + tokenConfig.getAppID() + "&secret=" + tokenConfig.getAppsecret() + "&code="
				+ code + "&grant_type=authorization_code").execute().returnContent().asString();
		return JSON.parseObject(userinfostr);
	}
}
