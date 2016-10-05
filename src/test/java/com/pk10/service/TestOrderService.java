package com.pk10.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pk10.bean.Goods;
import com.pk10.bean.Orders;
import com.pk10.bean.UserInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TestOrderService {

	@Autowired
	private OrdersService orderService;

	// private Orders order = new Orders(1,"", 200D, "ready", new Date(), null,
	// "liushao");

	private List<Goods> goods = new ArrayList<Goods>();
	private Orders order = new Orders("", 200D, "ready", new Date(), goods, "liushao");

	private UserInfo userInfo = new UserInfo("xxxxxxxxxxxx", "测试用名字222", 10000, new Date());

	@Test
	public void TestSave() throws Exception {

		for (int i = 0; i < 10; i++) {
			goods.add(new Goods(1, "测试商品" + i, 200D, "", 100));
		}

		System.out.println(orderService.save(order));
		System.out.println(order);
	}

	@Test
	public void TestUpdate() throws Exception {
		System.out.println(orderService.update(order));
	}

	@Test
	public void TestGetAll() throws Exception {
		System.out.println(orderService.getAll());
	}

	@Test
	public void TestGetOneById() throws Exception {
		System.out.println(orderService.getOneById(order));
	}

	@Test
	public void TestdeleteOneById() throws Exception {
		System.out.println(orderService.deleteOneById(order));
	}

	@Test
	public void TestGetListByOpenId() throws Exception {
		System.out.println(orderService.getListByOpenId(userInfo));
	}
}
