package com.pk10.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pk10.bean.UserInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TestUserInfoService {

	@Autowired
	private UserInfoService userInfoService; 
	
	private UserInfo userInfo = new UserInfo("xxxxxxxxxxxx", "测试用名字222", 10000D,new Date());
	
	@Test
	public void Testsave() throws Exception {
		System.out.println(userInfoService.save(userInfo));
	}

	@Test
	public void Testupdate() throws Exception {
		System.out.println(userInfoService.update(userInfo));
	}

	@Test
	public void TestgetAll() throws Exception {
		System.out.println(userInfoService.getAll());
	}

	@Test
	public void TestgetOneById() throws Exception {
		System.out.println(userInfoService.getOneById(userInfo));
	}

	@Test
	public void TestdeleteOneById() throws Exception {
		System.out.println(userInfoService.deleteOneById(userInfo));
	}
}