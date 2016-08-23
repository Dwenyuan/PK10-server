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
	public UserInfo cashPrize(UserInfo userInfo) throws Exception;

	/**
	 * 检测手机是否占用
	 * 
	 * @param userInfo
	 * @return
	 */
	UserInfo getUserInfoByTel(UserInfo userInfo);

	/**
	 * 检测用户名是否占用
	 * 
	 * @param userInfo
	 * @return
	 */
	UserInfo getUserInfoByUsername(UserInfo userInfo);

	/**
	 * 登录
	 * @param userInfo
	 * @return
	 */
	public UserInfo login(UserInfo userInfo);
}
