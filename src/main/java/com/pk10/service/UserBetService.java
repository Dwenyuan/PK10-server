package com.pk10.service;

import java.util.List;

import com.pk10.bean.UserBet;
import com.pk10.bean.UserInfo;

public interface UserBetService extends BaseService<UserBet> {

	List<UserBet> getBetsByUserId(int id);

	List<UserBet> getUserBetByOpenid(UserInfo userInfo) throws Exception;

	Integer saveList(List<UserBet> userBets) throws Exception;

	UserBet getOneByIdnum(UserBet userBet) throws Exception;

	/**
	 * 获取未兑奖的下注
	 * 
	 * @param userInfo 查询此用户的下注
	 * @return
	 * @throws Exception
	 */
	List<UserBet> getUnCashPrize(UserInfo userInfo) throws Exception;
	
	List<UserBet> getRecentlyBets(Integer limit);
}
