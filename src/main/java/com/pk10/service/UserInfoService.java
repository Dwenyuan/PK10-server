package com.pk10.service;

import com.pk10.bean.LotteryHistory;
import com.pk10.bean.UserInfo;

public interface UserInfoService extends BaseService<UserInfo> {
	/**
	 * 用户兑奖操作
	 * @param lotteryHistory
	 * @param userInfo
	 * @return
	 */
	public String cashPrize(LotteryHistory lotteryHistory, UserInfo userInfo);
}
