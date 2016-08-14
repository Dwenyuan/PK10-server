package com.pk10.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pk10.bean.BetType;
import com.pk10.bean.TokenConfig;
import com.pk10.bean.UserBet;
import com.pk10.bean.UserInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TestUserBetService {

	@Autowired
	private UserBetService userBetService;

	@Autowired
	private TokenConfig tokenConfig;

	// private UserBet userBet = new UserBet(10, BetType.NUMBER, 1000D, 5, "单",
	// new Date(), "xxxxxxxxxxxx",tokenConfig);

	private UserBet userBet = new UserBet(10, null, BetType.NUMBER, 1000D, 5, "单", new Date(), "xxxxxxxxxxxx", tokenConfig);
	
	private List<UserBet> list = new ArrayList<UserBet>();

	private UserInfo UserInfo = new UserInfo("xxxxxxxxxxxx");

	@Test
	public void TestSave() throws Exception {
		System.out.println("");
		System.out.println(userBetService.save(userBet));
	}

	@Test
	public void TestSaves() throws Exception {
		list.add(userBet);
		list.add(userBet);
		System.out.println(userBetService.saveList(list));
	}

	@Test
	public void TestUpdate() throws Exception {
		System.out.println(userBetService.update(userBet));
	}

	@Test
	public void TestGetAll() throws Exception {
		System.out.println(userBetService.getAll());
	}

	@Test
	public void TestGetOneById() throws Exception {
		System.out.println(userBetService.getOneById(userBet));
	}

	@Test
	public void TestdeleteOneById() throws Exception {
		System.out.println(userBetService.deleteOneById(userBet));
	}

	@Test
	public void TestgetUserBetByOpenid() throws Exception {
		System.out.println(userBetService.getUserBetByOpenid(UserInfo));
	}
}
