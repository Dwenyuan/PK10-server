package com.pk10.dao;

import com.pk10.bean.TokenConfig;

public interface TokenConfigDao extends BaseDao<TokenConfig> {

	TokenConfig getLastTokenConfig();
}
