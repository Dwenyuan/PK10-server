package com.pk10.dao;

import com.pk10.bean.LotteryHistory;
import com.pk10.bean.Notice;

public interface LotteryHistoryDao extends BaseDao<LotteryHistory> {
	public LotteryHistory getLastLottery() throws Exception;
}
