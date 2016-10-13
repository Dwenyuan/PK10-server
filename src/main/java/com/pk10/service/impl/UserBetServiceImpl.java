package com.pk10.service.impl;

import com.pk10.bean.BetInit;
import com.pk10.bean.TokenConfig;
import com.pk10.bean.UserBet;
import com.pk10.bean.UserInfo;
import com.pk10.dao.BetInitMapper;
import com.pk10.dao.UserBetDao;
import com.pk10.dao.UserInfoDao;
import com.pk10.service.TokenConfigService;
import com.pk10.service.UserBetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserBetServiceImpl implements UserBetService {

	@Autowired
	private UserBetDao userBetDao;

	@Autowired
	private UserInfoDao userInfoDao;

	@Autowired
	private TokenConfig tokenConfig;
	
	@Autowired
	private BetInitMapper betInitMapper;
	
	@Autowired
	private TokenConfigService tokenConfigService;

	@Override
	public Integer save(UserBet t) throws Exception {
		// 下注的同时，减去用户的金币
		UserInfo userInfo = userInfoDao.getOneById(new UserInfo(t.getUserid()));
		Integer balance = userInfo.getMoney() - t.getBetmoney();
		if (balance < 0)
			throw new Exception("余额不足");
		userInfo.setMoney(balance);
		t.setBetmoney(balance);
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
	public List<UserBet> getBetsByUserId(int id) {
		return userBetDao.getBetsByUserId(id);
	}

	@Override
	public List<UserBet> getUserBetByOpenid(UserInfo userInfo) throws Exception {
		return userBetDao.getUserBetByOpenid(userInfo);
	}

	@Override
	public Integer saveList(List<UserBet> userBets) throws Exception {
		TokenConfig safeTokenConfig = tokenConfigService.getLastTokenConfig();
		List<BetInit> betInits = betInitMapper.selectByGameName("猜字游戏");
		if (userBets.size() < 0)
			throw new Exception("user bet nothing or has a mistake");
		for (UserBet userBet : userBets) {
//			userBet.setTokenConfig(safeTokenConfig);
			userBet.setBetInits(betInits);
			userBet.setOdds(); // 设置倍率single
			userBet.setCreatedAt(new Date());
			UserInfo safeUserInfo = userInfoDao.getOneById(new UserInfo(userBet.getUserid()));
			int balance = safeUserInfo.getMoney() - userBet.getBetmoney();
			if (balance < 0)
				throw new Exception("balance is not enough");
			userBet.setBalance(balance);
			safeUserInfo.setMoney(balance);
			userInfoDao.update(safeUserInfo);
		}
		return userBetDao.saveList(userBets);
	}

	@Override
	public UserBet getOneByIdnum(UserBet userBet) throws Exception {
		return userBetDao.getOneByIdnum(userBet);
	}

	@Override
	public List<UserBet> getUnCashPrize(UserInfo userInfo) throws Exception {
		return userBetDao.getUnCashPrize(userInfo);
	}

	@Override
	public List<UserBet> getRecentlyBets(Integer userid, Integer limit) {
		return userBetDao.getRecentlyBets(userid, limit);
	}

	@Override
	public List<UserBet> getBetsByIdnum(Integer idnum, Integer userid) {
		return userBetDao.getBetsByIdnum(idnum, userid);
	}

	@Override
	public List<UserBet> getBetList(Integer curUserId, String startTime, String endTime) {
		return userBetDao.getBetList(curUserId, startTime, endTime);
	}

	public List<UserBet> getlastBets(Integer idnum) {
		return userBetDao.getlastBets(idnum);
	}

	@Override
	public List<UserBet> getBetsByIdnum(Integer idnum) {
		return userBetDao.getBetsByIdnum(idnum, null);
	}

    @Override
    public List<UserBet> findByBetweenIdnum(Integer startIdnum, Integer endIdnum) {
        return userBetDao.findByBetweenIdnum(startIdnum, endIdnum);
    }

}
