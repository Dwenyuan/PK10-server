package com.pk10.service;

import com.pk10.bean.AgentInfo;
import com.pk10.bean.UserInfo;

import java.util.List;

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

	/**
	 * 查询所有代理商
	 * @return
	 */
	public List<AgentInfo> getAllAgent();

	/**
	 * 通过ID查询代理商
	 * @param agentInfo
	 * @return
	 */
	public AgentInfo getAgentById(AgentInfo agentInfo);

	/**
	 * 更新代理商信息
	 * @param agentInfo
	 * @return
	 */
	public Integer updateAgent(AgentInfo agentInfo);

	/**
	 * 添加代理商
	 * @param agentInfo
	 * @return
	 */
	public Integer savaAgent(AgentInfo agentInfo);
}
