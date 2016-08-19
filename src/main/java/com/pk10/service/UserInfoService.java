package com.pk10.service;

import com.pk10.bean.UserInfo;

public interface UserInfoService extends BaseService<UserInfo> {
	/**
	 * 用户兑奖操作
	 * 
	 * @param lotteryHistory
	 * @param userInfo
	 * @return
	 * @throws Exception 
	 */
	public String cashPrize(UserInfo userInfo) throws Exception;
}
