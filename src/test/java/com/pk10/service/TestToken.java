package com.pk10.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pk10.bean.TokenInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TestToken {

	@Autowired
	TokenInfoService tokenInfoService;
	
	@Test
	public void test(){
		System.out.println("OK");
	}
	
	@Test
	public void testSaveTokenInfo() throws Exception{
		TokenInfo tokenInfo = new TokenInfo("fjyYAdjtx0-KJF-Ol9jm-rSp5rjIem1n-w54exD9xz5QNsvyNOOHsBlp0n-_6vSbvlmKjyZxOZInOlZ4l-nqUITF5-wfd6b51vX1ZWWrPQGZ4MJA8_HEtiexf0GNYj_uXSWbAIACXB", new Date(), new Date());
		tokenInfoService.save(tokenInfo);
	}
	@Test
	public void TestGetTokenFromNet() throws Exception{
		TokenInfo geTokenInfoFormNet = tokenInfoService.geTokenInfoFormNet();
	}
}
