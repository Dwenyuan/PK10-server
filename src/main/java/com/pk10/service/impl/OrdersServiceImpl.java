package com.pk10.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk10.bean.Orders;
import com.pk10.bean.UserInfo;
import com.pk10.dao.OrdersDao;
import com.pk10.dao.OrdersHasGoodsDao;
import com.pk10.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersDao orderDao;

	@Autowired
	private OrdersHasGoodsDao ordersHasGoodsDao;

	@Override
	public Integer save(Orders t, UserInfo u) throws Exception {
		return orderDao.save(t);
	}

	@Override
	public Integer update(Orders t) throws Exception {
		return orderDao.update(t);
	}

	@Override
	public List<Orders> getAll() throws Exception {
		return orderDao.getAll();
	}

	@Override
	public Orders getOneById(Orders t) throws Exception {
		return orderDao.getOneById(t);
	}

	@Override
	public Integer deleteOneById(Orders t) throws Exception {
		return orderDao.deleteOneById(t);
	}

	@Override
	public List<Orders> getListByOpenId(UserInfo userInfo) throws Exception {
		return orderDao.getListByOpenId(userInfo);
	}

	/**
	 * 创建订单时要先创建关联
	 */
	@Override
	public Integer save(Orders t) throws Exception {
		if (orderDao.save(t) != 0) {
			return ordersHasGoodsDao.save(t);
		}
		return 0;
	}

}
