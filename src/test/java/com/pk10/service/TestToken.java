package com.pk10.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pk10.bean.TokenConfig;
import com.pk10.bean.TokenInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TestToken {

	@Autowired
	TokenInfoService tokenInfoService;
	
	@Autowired
	TokenConfigService tokenConfigService;
	
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
	
	@Test
	public void TestGetLastToken() throws Exception{
		TokenInfo lastTokenInfo = tokenInfoService.getLastTokenInfo();
		System.out.println(lastTokenInfo);
	}
	
	
	@Test
	public void TestTokenConfigSave() throws Exception{
		TokenConfig tokenConfig = new TokenConfig(null, null, null, "PK10", 9D, 1.5, 1.5, 10000D, null);
		Integer save = tokenConfigService.save(tokenConfig);
		System.out.println(save);
	}
	
	@Test
	public void TestGetTokenConfigAll() throws Exception {
		System.out.println(tokenConfigService.getAll());
	}
	
	@Test
	public void TestUpdateTokenConfig() throws Exception{
		TokenConfig tokenConfig = new TokenConfig(2,null, null, null, "PK10", 5D, 1.5, 1.5, 223300D, null);
		Integer updateById = tokenConfigService.updateById(tokenConfig);
		System.out.println(updateById);
	}
}
