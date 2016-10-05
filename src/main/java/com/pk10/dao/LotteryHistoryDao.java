package com.pk10.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pk10.bean.LotteryHistory;

public interface LotteryHistoryDao extends BaseDao<LotteryHistory> {
	public LotteryHistory getLastLottery() throws Exception;

	public List<LotteryHistory> getLastNumLottery(@Param("param") Integer num);

	public List<LotteryHistory> getNumsById(@Param("param")List<Integer> nums);
}
