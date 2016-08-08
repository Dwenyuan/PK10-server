package com.pk10.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pk10.bean.Goods;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TestGoodsService {

	@Autowired
	private GoodsService goodsService;

	private Goods goods = new Goods("测试用商品", 200D, "http://s.cn.bing.net/th?id=OJ.zPJyccrUWF0Gsw&pid=MsnJVFeeds&w=16&h=16", 20);

	@Test
	public void TestSave() throws Exception {
		System.out.println(goodsService.save(goods));
	}

	@Test
	public void TestUpdate() throws Exception {
		System.out.println(goodsService.update(goods));
	}

	@Test
	public void TestGetAll() throws Exception {
		System.out.println(goodsService.getAll());
	}

	@Test
	public void TestGetOneById() throws Exception {
		System.out.println(goodsService.getOneById(goods));
	}


	@Test
	public void TestdeleteOneById() throws Exception {
		System.out.println(goodsService.deleteOneById(goods));
	}

}
