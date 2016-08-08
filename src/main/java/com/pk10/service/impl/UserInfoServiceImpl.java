package com.pk10.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk10.bean.UserInfo;
import com.pk10.dao.UserInfoDao;
import com.pk10.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;
	@Override
	public Integer save(UserInfo t) throws Exception {
		if (userInfoDao.update(t)==0) {
			return userInfoDao.save(t);
		}else{
			return 0;
		}
	}

	@Override
	public Integer update(UserInfo t) throws Exception {
		return userInfoDao.update(t);
	}

	@Override
	public List<UserInfo> getAll() throws Exception {
		return userInfoDao.getAll();
	}

	@Override
	public UserInfo getOneById(UserInfo t) throws Exception {
		return userInfoDao.getOneById(t);
	}

	@Override
	public Integer deleteOneById(UserInfo t) throws Exception {
		return userInfoDao.deleteOneById(t);
	}

}
