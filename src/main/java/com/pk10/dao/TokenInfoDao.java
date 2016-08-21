package com.pk10.dao;

import com.pk10.bean.TokenInfo;

public interface TokenInfoDao extends BaseDao<TokenInfo> {

	/**
	 * 配置通常只有一条，只获取这单独一条
	 * @return 
	 */
	public TokenInfo getLastTokenInfo();
}
