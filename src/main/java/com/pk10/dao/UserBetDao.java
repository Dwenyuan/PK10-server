package com.pk10.dao;

import com.pk10.bean.UserBet;
import com.pk10.bean.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserBetDao extends BaseDao<UserBet> {

	List<UserBet> getBetsByUserId(int userid);

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

	/**
	 * 获取最近100期的投注记录
	 * 
	 * @return
	 */
	List<UserBet> getRecentlyBets(@Param("userid") Integer userid, @Param("limit") Integer limit);

	List<UserBet> getBetsByIdnum(@Param("idnum") Integer idnum, @Param("userid") Integer userid);

	List<UserBet> getBetList(@Param("curUserId") Integer curUserId, @Param("startTime") String startTime,
			@Param("endTime") String endTime);

	List<UserBet> getlastBets(@Param("idnum") Integer idnum);

}
