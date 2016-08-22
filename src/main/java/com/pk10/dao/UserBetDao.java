package com.pk10.dao;

import java.util.List;

import com.pk10.bean.UserBet;
import com.pk10.bean.UserInfo;

public interface UserBetDao extends BaseDao<UserBet> {

	List<UserBet> getUserBetByOpenid(UserInfo userInfo);

	Integer saveList(List<UserBet> userBets);

	UserBet getOneByIdnum(UserBet userBet);

	/**
	 * 获取指定用户未兑奖的订单
	 * 
	 * @param userInfo
	 * @return
	 */
	List<UserBet> getUnCashPrize(UserInfo userInfo);
}
