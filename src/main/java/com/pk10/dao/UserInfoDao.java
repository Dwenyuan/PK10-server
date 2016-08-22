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
	
	/**
	 * 检测手机是否占用
	 * @param userInfo
	 * @return
	 */
	UserInfo getUserInfoByTel(UserInfo userInfo);
	
	/**
	 * 检测用户名是否占用
	 * @param userInfo
	 * @return
	 */
	UserInfo getUserInfoByUsername(UserInfo userInfo);
	
	UserInfo login(UserInfo userInfo);
}
