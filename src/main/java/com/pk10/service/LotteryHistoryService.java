package com.pk10.service;

import com.pk10.bean.LotteryHistory;

public interface LotteryHistoryService extends BaseService<LotteryHistory>{
	public LotteryHistory getLastLottery() throws Exception;
}
