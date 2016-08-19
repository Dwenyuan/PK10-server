package com.pk10.service;

import com.pk10.bean.TokenConfig;

public interface TokenConfigService extends BaseService<TokenConfig> {
	public TokenConfig getLastTokenConfig();
}
