package com.pk10.service.impl;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pk10.bean.Datagrid;
import com.pk10.bean.Page;
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
		if (lotteryHistoryDao.update(t) > 0) {
			return 0;
		} else {
			return lotteryHistoryDao.save(t);
		}
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
		for (int i = 0; i < 40; i++) {
			LotteryHistory lottery = lotteryHistoryDao.getOneById(t);
			if (lottery == null) { // 还没有获取到最新的开奖结果，等待收集器收集结果
				Thread.sleep(3000);
				continue;
			} else {
				return lottery;
			}
		}
		throw new Exception("get lottery num has a error");
	}

	@Override
	public Integer deleteOneById(LotteryHistory t) throws Exception {
		return lotteryHistoryDao.deleteOneById(t);
	}

	@Override
	public LotteryHistory getLastLottery() throws Exception {
		LotteryHistory lastLottery = lotteryHistoryDao.getLastLottery();
		Date createdAt = lastLottery.getCreatedAt();
		long time = System.currentTimeMillis() - createdAt.getTime(); // 查看获取的开奖记录是否是最近的开奖记录
		if (time < 1000 * 60 * 5) {
			return lotteryHistoryDao.getLastLottery();
		} else {
			Thread.sleep(1000); // 如果获取开奖记录时间超过5分钟 说明还没有 收集到开奖记录 等待2秒钟重新获取
			return this.getLastLottery();
		}
	}

	@Override
	public List<LotteryHistory> getLastLottery(Integer num) {
		return lotteryHistoryDao.getLastNumLottery(num);
	}

	@Override
	public Datagrid getAllInPage(Page page) throws Exception {
		PageHelper.startPage(page.getPages(), 10);
		List<LotteryHistory> lotteryHistories = lotteryHistoryDao.getAll();
		PageInfo pageInfo = new PageInfo(lotteryHistories);
		Datagrid datagrid = new Datagrid();
		datagrid.setRows(lotteryHistories);
		datagrid.setTotal(pageInfo.getTotal());
		datagrid.setCurrentPage(page.getPages());
		datagrid.setTotalPage(pageInfo.getPages());

		return datagrid;
	}

	@Override
	public LotteryHistory getHistoryById(LotteryHistory lotteryHistory) throws Exception {
		return lotteryHistoryDao.getOneById(lotteryHistory);
	}

	@Override
	public List<LotteryHistory> getNumsById(List<Integer> nums) {
		return lotteryHistoryDao.getNumsById(nums);
	}
}
