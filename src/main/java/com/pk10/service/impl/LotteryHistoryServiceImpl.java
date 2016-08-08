package com.pk10.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk10.bean.LotteryHistory;
import com.pk10.dao.LotteryHistoryDao;
import com.pk10.service.LotteryHistoryService;

@Service
public class LotteryHistoryServiceImpl implements LotteryHistoryService {

	@Autowired
	private LotteryHistoryDao lotteryHistoryDao;

	@Override
	public Integer save(LotteryHistory t) throws Exception {
		return lotteryHistoryDao.save(t);
	}

	@Override
	public Integer update(LotteryHistory t) throws Exception {
		return lotteryHistoryDao.update(t);
	}

	@Override
	public List<LotteryHistory> getAll() throws Exception {
		return lotteryHistoryDao.getAll();
	}

	@Override
	public LotteryHistory getOneById(LotteryHistory t) throws Exception {
		return lotteryHistoryDao.getOneById(t);
	}

	@Override
	public Integer deleteOneById(LotteryHistory t) throws Exception {
		return lotteryHistoryDao.deleteOneById(t);
	}

	@Override
	public LotteryHistory getLastLottery() throws Exception {
		return lotteryHistoryDao.getLastLottery();
	}
	
}
