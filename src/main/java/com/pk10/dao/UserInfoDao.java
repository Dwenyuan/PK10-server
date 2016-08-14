package com.pk10.dao;

import com.pk10.bean.LotteryHistory;
import com.pk10.bean.UserInfo;

public interface UserInfoDao extends BaseDao<UserInfo> {

	/**
	 * 用户兑奖
	 * 
	 * @param lotteryHistory
	 * @param userInfo
	 * @return
	 */
	String cashPrize(LotteryHistory lotteryHistory, UserInfo userInfo);
}
