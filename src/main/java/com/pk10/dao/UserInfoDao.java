package com.pk10.dao;

import com.pk10.bean.AgentInfo;
import com.pk10.bean.LotteryHistory;
import com.pk10.bean.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

	UserInfo login(UserInfo userInfo);

	/**
	 * 管理员登录
	 * 
	 * @param userInfo
	 * @return
	 */
	UserInfo managerLogin(UserInfo userInfo);

	/*代理商的增改查，删除和删除普通用户一样，无需重写*/
	//添加代理商
	Integer saveAgent(AgentInfo agentInfo);
	//修改代理商
	Integer updateAgentByPrimaryKeySelective(AgentInfo agentInfo);
    //查询所有代理商
	List<AgentInfo> getAllAgent(AgentInfo agentInfo);
    //通过ID查询指定代理商
	AgentInfo getAgentById(AgentInfo agentInfo);
    //查询代理商下所有用户
	List<UserInfo> getUserForAgent(UserInfo userInfo);

    List<UserInfo> getAgentsById(Integer id);

    List<UserInfo> getAgentsByOwnerId(Integer ownerId);

    List<UserInfo> getUsersByAgentId(@Param("username") String username, @Param("agentId") Integer agentId);
	UserInfo getUserUsername(UserInfo userInfo);

}