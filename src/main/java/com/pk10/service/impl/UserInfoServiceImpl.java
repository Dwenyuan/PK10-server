package com.pk10.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk10.bean.LotteryHistory;
import com.pk10.bean.TokenConfig;
import com.pk10.bean.UserBet;
import com.pk10.bean.UserInfo;
import com.pk10.dao.LotteryHistoryDao;
import com.pk10.dao.UserInfoDao;
import com.pk10.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;

	@Autowired
	private TokenConfig tokenConfig;

	@Autowired
	private LotteryHistoryDao lotteryHistoryDao;

	@Override
	public Integer save(UserInfo t) throws Exception {
		if (userInfoDao.update(t) == 0) {
			return userInfoDao.save(t);
		} else {
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
		UserInfo userInfo = userInfoDao.getOneById(t);
		if (userInfo == null) {
			t.setMoney(tokenConfig.getMoney());// 如果用户第一次登录则赠送 默认数的金币
			userInfoDao.save(t);
			return t;
		} else {
			return userInfo;
		}
	}

	@Override
	public Integer deleteOneById(UserInfo t) throws Exception {
		return userInfoDao.deleteOneById(t);
	}

	@Override
	public String cashPrize(List<UserBet> userBets, UserInfo userInfo) throws Exception {
		for (UserBet userBet : userBets) {
			LotteryHistory lotteryHistory = lotteryHistoryDao.getOneById(new LotteryHistory(userBet.getIdnum(), null, null));
			String[] split = lotteryHistory.getLotterynums().split(",");
			Integer lotterynum = (Integer.parseInt(split[0]) + Integer.parseInt(split[split.length - 1])) % 10;
		}
		return null;
	}

}
