package com.pk10.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk10.bean.UserBet;
import com.pk10.bean.UserInfo;
import com.pk10.dao.UserBetDao;
import com.pk10.dao.UserInfoDao;
import com.pk10.service.UserBetService;

@Service
public class UserBetServiceImpl implements UserBetService {

	@Autowired
	private UserBetDao userBetDao;

	@Autowired
	private UserInfoDao userInfoDao;

	@Override
	public Integer save(UserBet t) throws Exception {
		// 下注的同时，减去用户的金币
		UserInfo userInfo = userInfoDao.getOneById(new UserInfo(t.getUserinfoOpenid()));
		Double balance = userInfo.getMoney() - t.getBetmoney();
		if (balance < 0)
			throw new Exception("余额不足");
		userInfo.setMoney(balance);
		userInfoDao.update(userInfo);
		return userBetDao.save(t);
	}

	@Override
	public Integer update(UserBet t) throws Exception {
		return userBetDao.update(t);
	}

	@Override
	public List<UserBet> getAll() throws Exception {
		return userBetDao.getAll();
	}

	@Override
	public UserBet getOneById(UserBet t) throws Exception {
		return userBetDao.getOneById(t);
	}

	@Override
	public Integer deleteOneById(UserBet t) throws Exception {
		return userBetDao.deleteOneById(t);
	}

	@Override
	public List<UserBet> getUserBetByOpenid(UserInfo userInfo) throws Exception {
		return userBetDao.getUserBetByOpenid(userInfo);
	}

	@Override
	public Integer saveList(List<UserBet> userBets) throws Exception {
		if (userBets.size() < 0)
			throw new Exception("没有下注,或者下注出错");
		return userBetDao.saveList(userBets);
	}

}
