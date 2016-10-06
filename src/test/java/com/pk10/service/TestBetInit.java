package com.pk10.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pk10.bean.BetInit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TestBetInit {

	
	@Autowired
	private BetInitService betInitService;
	
	@Test
	public void TestSelectByName(){
		
		List<BetInit> betInitByName = betInitService.getBetInitByName(new BetInit("猜字游戏"));
		System.out.println(betInitByName);
	}
}
