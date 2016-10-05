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

	private UserBet userBet;

	private List<UserBet> list = new ArrayList<UserBet>();

	private UserInfo UserInfo = new UserInfo(29);

	@Test
	public void TestSave() throws Exception {
		System.out.println("");
		userBet = new UserBet(10, null, BetType.NUMBER, 1000, 5, "单", new Date(), 29, tokenConfig);
		System.out.println(userBetService.save(userBet));
	}

	@Test
	public void TestSaves() throws Exception {
		list.add(new UserBet(571175, BetType.NUMBER, 1000, 5, "single", new Date(), 29, tokenConfig));
		list.add(new UserBet(571175, BetType.NUMBER, 1000, 5, "single", new Date(), 29, tokenConfig));
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

	@Test
	public void TestGetUnCashPrize() throws Exception {
		System.out.println(userBetService.getUnCashPrize(new UserInfo(29)));
	}

	@Test
	public void TestGetBetsByIdNum() throws Exception {
		System.out.println(userBetService.getBetsByIdnum(579302));
	}

	@Test
	public void TestgetRecentlyBets() {
		System.out.println(userBetService.getRecentlyBets(31, 5));
	}

	@Test
	public void merge() throws CloneNotSupportedException {
		List<UserBet> userBets = new ArrayList<UserBet>();
		userBets.add(new UserBet(10, 577791, BetType.NUMBER, 1000, 5, "单", new Date(), 29, tokenConfig));
		userBets.add(new UserBet(10, 577791, BetType.NUMBER, 1000, 5, "单", new Date(), 29, tokenConfig));
		userBets.add(new UserBet(11, 577791, BetType.NUMBER, 1000, 5, "单", new Date(), 29, tokenConfig));
		userBets.add(new UserBet(12, 577792, BetType.NUMBER, 1000, 5, "单", new Date(), 29, tokenConfig));
		userBets.add(new UserBet(13, 577792, BetType.NUMBER, 1000, 5, "单", new Date(), 29, tokenConfig));
		userBets.add(new UserBet(13, 577792, BetType.NUMBER, 1000, 5, "单", new Date(), 29, tokenConfig));
		userBets.add(new UserBet(13, 577792, BetType.NUMBER, 1000, 5, "1", new Date(), 29, tokenConfig));
		userBets.add(new UserBet(13, 577792, BetType.NUMBER, 2000, 5, "1", new Date(), 29, tokenConfig));
		userBets.add(new UserBet(13, 577792, BetType.NUMBER, 3000, 5, "1", new Date(), 29, tokenConfig));
		userBets.add(new UserBet(13, 577792, BetType.NUMBER, 4000, 5, "1", new Date(), 29, tokenConfig));
		userBets.add(new UserBet(13, 577792, BetType.NUMBER, 1000, 5, "1", new Date(), 29, tokenConfig));
		System.out.println(mergebets(userBets).size());
		for (UserBet userBet : mergebets(userBets)) {
			System.out.println(userBet);
		}
	}

	@Test
	public void TestClone() throws CloneNotSupportedException {
		UserBet userBet = new UserBet(10, 577791, BetType.NUMBER, 1000, 5, "单", new Date(), 29, tokenConfig);
		UserBet userBet2 = userBet.clone();
		System.out.println(userBet == userBet2);
		System.out.println(userBet.getBetmoney() + "===" + userBet2.getBetmoney());
		userBet.setBetmoney(2);
		System.out.println(userBet.getBetmoney() + "===" + userBet2.getBetmoney());
	}

	public static List<UserBet> mergebets(List<UserBet> userBets) throws CloneNotSupportedException {
		List<UserBet> result = new ArrayList<UserBet>();
		UserBet temp = null;
		for (UserBet userBet : userBets) {
			if (result.size() == 0) {
				result.add(userBet.clone());
			} else {
				for (UserBet value : result) {
					if (checkEqule(userBet, value)) {
						temp = value;
					}
				}
				if (temp != null) {
					temp.setBetmoney(temp.getBetmoney() + userBet.getBetmoney());
					temp = null;
				} else {
					result.add(userBet.clone());
				}
			}
		}
		return result;
	}

	public static boolean checkEqule(UserBet key1, UserBet key2) {
		if (key1.getUserid().equals(key2.getUserid()) && key1.getBetnum().equals(key2.getBetnum())
				&& key1.getIdnum().equals(key2.getIdnum()) && key1.getType().equals(key2.getType())) {
			return true;
		} else {
			return false;
		}
	}
}
