package com.pk10.dao;

import com.pk10.bean.LotteryHistory;
import com.pk10.bean.UserInfo;

public interface UserInfoDao extends BaseDao<UserInfo> {

	String cashPrize(LotteryHistory lotteryHistory, UserInfo userInfo);
}
