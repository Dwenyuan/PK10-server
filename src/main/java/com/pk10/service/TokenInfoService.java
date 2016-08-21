package com.pk10.service;

import com.pk10.bean.TokenInfo;

public interface TokenInfoService extends BaseService<TokenInfo>{
	public TokenInfo geTokenInfoFormNet() throws Exception; // 从网络获取token
	
	public TokenInfo getLastTokenInfo() throws Exception;
}
