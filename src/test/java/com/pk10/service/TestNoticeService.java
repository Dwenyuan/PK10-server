package com.pk10.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pk10.bean.Notice;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TestNoticeService {

	@Autowired
	private NoticeService noticeService;

	private Notice notice = new Notice("测试用title", "测试用内容", new Date());

	@Test
	public void TestSave() throws Exception {
		System.out.println(noticeService.save(notice));
	}

	@Test
	public void TestUpdate() throws Exception {
		System.out.println(noticeService.update(notice));
	}

	@Test
	public void TestGetAll() throws Exception {
		System.out.println(noticeService.getAll());
	}

	@Test
	public void TestGetOneById() throws Exception {
		System.out.println(noticeService.getOneById(notice));
	}

	@Test
	public void TestGetLastNotice() throws Exception {
		System.out.println(noticeService.getLastNotice());
	}

	@Test
	public void TestdeleteOneById() throws Exception {
		System.out.println(noticeService.deleteOneById(notice));
	}

}
