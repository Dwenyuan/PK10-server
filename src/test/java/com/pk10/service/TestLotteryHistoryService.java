package com.pk10.service;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pk10.bean.LotteryHistory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TestLotteryHistoryService {

	@Autowired
	private LotteryHistoryService lotteryHistoryService;

	private LotteryHistory lotteryHistory = new LotteryHistory(0001, new Date(), "06,04,01,02,08,10,05,09,07,03");

	@Test
	public void TestSave() throws Exception {
		System.out.println(lotteryHistoryService.save(lotteryHistory));
	}

	@Test
	public void TestUpdate() throws Exception {
		System.out.println(lotteryHistoryService.update(lotteryHistory));
	}

	@Test
	public void TestGetAll() throws Exception {
		System.out.println(lotteryHistoryService.getAll());
	}

	@Test
	public void TestGetOneById() throws Exception {
		System.out.println(lotteryHistoryService.getOneById(lotteryHistory));
	}

	@Test
	public void TestGetLastNotice() throws Exception {
		System.out.println(lotteryHistoryService.getLastLottery());
	}

	@Test
	public void TestGetNumLastLotteryHistory() {
		System.out.println(lotteryHistoryService.getLastLottery(5));
	}

	@Test
	public void TestdeleteOneById() throws Exception {
		System.out.println(lotteryHistoryService.deleteOneById(lotteryHistory));
	}

	@Test
	public void TestGetNumsById() throws Exception {
		// int[] list = { 574355, 574356, 574357 };
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(574355);
		list.add(574356);
		list.add(574357);
		System.out.println(lotteryHistoryService.getNumsById(list));
	}
}
