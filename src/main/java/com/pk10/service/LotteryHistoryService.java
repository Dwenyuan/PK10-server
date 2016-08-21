package com.pk10.service;

import java.util.List;

import com.pk10.bean.LotteryHistory;

public interface LotteryHistoryService extends BaseService<LotteryHistory>{
	
	public LotteryHistory getLastLottery() throws Exception;

	/**
	 * 获取制定条数的获奖记录,例如获取最近100条开奖记录
	 * @param num
	 * @return
	 */
	public List<LotteryHistory> getLastLottery(Integer num);
}
