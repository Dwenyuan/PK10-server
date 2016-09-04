package com.pk10.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk10.bean.TokenConfig;
import com.pk10.dao.TokenConfigDao;
import com.pk10.service.TokenConfigService;

@Service
public class TokenConfigServiceImpl implements TokenConfigService {

	@Autowired
	private TokenConfigDao tokenConfigDao;

	@Override
	public Integer save(TokenConfig t) throws Exception {
		return tokenConfigDao.save(t);
	}

	@Override
	public Integer updateById(TokenConfig t) throws Exception{
		return tokenConfigDao.updateById(t);
	}
	
	@Override
	public Integer update(TokenConfig t) throws Exception {
		return tokenConfigDao.update(t);
	}

	@Override
	public List<TokenConfig> getAll() throws Exception {
		return tokenConfigDao.getAll();
	}

	@Override
	public TokenConfig getOneById(TokenConfig t) throws Exception {
		return tokenConfigDao.getOneById(t);
	}

	@Override
	public Integer deleteOneById(TokenConfig t) throws Exception {
		return null;
	}

	@Override
	public TokenConfig getLastTokenConfig() {
		return tokenConfigDao.getLastTokenConfig();
	}

}
