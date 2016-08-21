package com.pk10.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pk10.bean.TokenConfig;
import com.pk10.bean.TokenInfo;
import com.pk10.dao.TokenInfoDao;
import com.pk10.service.TokenInfoService;

@Service
public class TokenInfoServiceImpl implements TokenInfoService {

	@Autowired
	private TokenInfoDao tokenInfoDao;

	@Autowired
	private TokenConfig tokenConfig;

	private static final Logger logger = LoggerFactory.getLogger(TokenInfoServiceImpl.class);

	@Override
	public Integer save(TokenInfo t) throws Exception {
		Integer safenum = tokenInfoDao.update(t);
		if (safenum < 1) {
			return tokenInfoDao.save(t);
		} else {
			return safenum;
		}
	}

	@Override
	public Integer update(TokenInfo t) throws Exception {
		return tokenInfoDao.update(t);
	}

	@Override
	public List<TokenInfo> getAll() throws Exception {
		return tokenInfoDao.getAll();
	}

	@Override
	public TokenInfo getOneById(TokenInfo t) throws Exception {
		return tokenInfoDao.getOneById(t);
	}

	@Override
	public Integer deleteOneById(TokenInfo t) throws Exception {
		return tokenInfoDao.deleteOneById(t);
	}

	@Override
	public TokenInfo geTokenInfoFormNet() throws Exception {

		HttpClient client = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(tokenConfig.getTokenUrl() + "&appid=" + tokenConfig.getAppID() + "&secret=" + tokenConfig.getAppsecret());
		HttpResponse response = client.execute(httpGet);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuffer stringBuffer = new StringBuffer();
		String line = "";
		while ((line = bufferedReader.readLine()) != null) {
			stringBuffer.append(line);
		}
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) JSONObject.parse(stringBuffer.toString());
		if (map.get("access_token") != null) {
			TokenInfo tokenInfo = new TokenInfo(map.get("access_token"), new Date(), new Date());
			tokenInfoDao.update(tokenInfo);
			return tokenInfo;
		} else {
			logger.warn(stringBuffer.toString());
			return null;
		}
	}

	@Override
	public TokenInfo getLastTokenInfo() throws Exception {
		return tokenInfoDao.getLastTokenInfo();
	}

}
