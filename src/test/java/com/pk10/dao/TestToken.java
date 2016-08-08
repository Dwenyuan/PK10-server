package com.pk10.dao;

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
	TokenInfoDao tokenInfoDao;
	
	@Test
	public void testEn(){
		System.out.println("ok");
	} 
	
	@Test
	public void testTokenInfoDao() throws Exception{
		TokenInfo tokenInfo = new TokenInfo("fjyYAdjtx0-KJF-Ol9jm-rSp5rjIem1n-w54exD9xz5QNsvyNOOHsBlp0n-_6vSbvlmKjyZxOZInOlZ4l-nqUITF5-wfd6b51vX1ZWWrPQGZ4MJA8_HEtiexf0GNYj_uXSWbAIACXB", new Date(), new Date());
		Integer saveToken = tokenInfoDao.save(tokenInfo);
		System.out.println(saveToken);
	}
	
	@Test
	public void TestTokenInfoUpdate() throws Exception{
		TokenInfo tokenInfo = new TokenInfo("vlmKjyZxOZInOlZ4l-nqUITF5-wfd6b51vX1ZWWrPQGZ4MJA8_HEtiexf0GNYj_uXSWbAIACXB", new Date(), new Date());
		Integer update = tokenInfoDao.update(tokenInfo);
		System.out.println(update);
	}
	@Test
	public void TestGetToken() throws Exception{
		TokenInfo tokenInfo = new TokenInfo("", new Date(), new Date());
		TokenInfo tokenInfo2 = tokenInfoDao.getOneById(tokenInfo);
		System.out.println(tokenInfo2);
	}
}
