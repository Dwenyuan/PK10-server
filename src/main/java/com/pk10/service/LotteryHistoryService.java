package com.pk10.service;

import java.util.List;

import com.pk10.bean.Datagrid;
import com.pk10.bean.LotteryHistory;
import com.pk10.bean.Page;

public interface LotteryHistoryService extends BaseService<LotteryHistory>{
	
	public LotteryHistory getLastLottery() throws Exception;

	/**
	 * 获取制定条数的获奖记录,例如获取最近100条开奖记录
	 * @param num
	 * @return
	 */
	public List<LotteryHistory> getLastLottery(Integer num);

	public Datagrid getAllInPage(Page page) throws Exception;

    public LotteryHistory getHistoryById(LotteryHistory lotteryHistory) throws Exception;

    /**
     * 根据id 批量获取开奖结果
     * @param nums
     * @return
     */
	public List<LotteryHistory> getNumsById(List<Integer> nums);
}
