package com.pk10.service.impl;

import java.util.List;

import com.pk10.bean.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.pk10.dao.LotteryHistoryDao;
import com.pk10.dao.UserBetDao;
import com.pk10.dao.UserInfoDao;
import com.pk10.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

	@Autowired
	private UserInfoDao userInfoDao;
	@Autowired
	private UserBetDao userBetDao;
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
	public UserInfo cashPrize(UserInfo userInfo) throws Exception {
		UserInfo safeUserInfo = userInfoDao.getOneById(userInfo);
		List<UserBet> userBets = userBetDao.getUnCashPrize(safeUserInfo);
		for (UserBet userBet : userBets) {
			// 获取档期开奖结果 如果获取不到说明还没有从网上下载下来，则等待3秒钟再去查询
			LotteryHistory lotteryHistory = null;
			for (int i = 0; i < 30; i++) {
				lotteryHistory = lotteryHistoryDao.getOneById(new LotteryHistory(userBet.getIdnum(), null, null));
				if (lotteryHistory == null) {
					Thread.sleep(3000);
					continue;
				} else {
					break;
				}
			}
			// 如果60秒后还是查不到 则放弃
			if (lotteryHistory == null) {
				throw new Exception("get bouns result error");
			}
			String[] split = lotteryHistory.getLotterynums().split(",");
			Integer lotterynum = (Integer.parseInt(split[0]) + Integer.parseInt(split[split.length - 1])) % 10; // 计算中奖号码
			switch (userBet.getType()) {
			case NUMBER:
				if (Integer.parseInt(userBet.getBetnum()) == lotterynum) { // 中奖了
					cashUpdateUser(safeUserInfo, userBet);
				} else { // 未中奖
					userBetDao.update(userBet); // 重置兑奖标志位
				}
				break;
			case BIG_OR_SMALL:
				if ("single".equals(userBet.getBetnum()) && lotterynum % 2 == 1) {
					cashUpdateUser(safeUserInfo, userBet);
				} else if ("double".equals(userBet.getBetnum()) && lotterynum % 2 == 0) {
					cashUpdateUser(safeUserInfo, userBet);
				} else {
					userBetDao.update(userBet);
				}
				break;
			case SINGLE_OR_DOUBLE:
				if ("big".equals(userBet.getBetnum()) && lotterynum >= 5) {
					cashUpdateUser(safeUserInfo, userBet);
				} else if ("small".equals(userBet.getBetnum()) && lotterynum < 5) {
					cashUpdateUser(safeUserInfo, userBet);
				} else {
					userBetDao.update(userBet);
				}
				break;
			default:
				break;
			}
		}
		return safeUserInfo;
	}

	private void cashUpdateUser(UserInfo safeUserInfo, UserBet userBet) throws Exception {
		logger.info("bonus number:" + userBet.getBetnum() + "cash a prizeing....");
		safeUserInfo.setMoney(safeUserInfo.getMoney() + userBet.getBetmoney() * userBet.getOdds());
		userInfoDao.update(safeUserInfo);
		userBetDao.update(userBet);// 兑奖后重置标志位表示已兑奖
		logger.info("bonus number:" + userBet.getBetnum() + "cash a prizeing....");
	}

	@Override
	public UserInfo getUserInfoByTel(UserInfo userInfo) {
		return userInfoDao.getUserInfoByTel(userInfo);
	}

	@Override
	public UserInfo getUserInfoByUsername(UserInfo userInfo) {
		return userInfoDao.getUserInfoByUsername(userInfo);
	}

	@Override
	public UserInfo login(UserInfo userInfo) {
		return userInfoDao.login(userInfo);
	}

	@Override
	public UserInfo managerLogin(UserInfo userInfo) {
		return userInfoDao.managerLogin(userInfo);
	}

	@Override
	public List<AgentInfo> getAllAgent() {
		return userInfoDao.getAllAgent();
	}

	@Override
	public AgentInfo getAgentById(AgentInfo agentInfo) {
		return userInfoDao.getAgentById(agentInfo);
	}

	@Override
	public Integer updateAgent(AgentInfo agentInfo) {
		return userInfoDao.updateAgentByPrimaryKeySelective(agentInfo);
	}

	@Override
	public Integer savaAgent(AgentInfo agentInfo) {
		return userInfoDao.saveAgent(agentInfo);
	}

	@Override
	public List<UserInfo> getUserForAgent(UserInfo userInfo) {
		return userInfoDao.getUserForAgent(userInfo);
	}
}
