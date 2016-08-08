package com.pk10.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk10.bean.OrdersHasGoods;
import com.pk10.dao.OrdersHasGoodsDao;
import com.pk10.service.OrdersHasGoodsService;

@Service
public class OrdersHasGoodsServiceImpl implements OrdersHasGoodsService {

	@Autowired
	private OrdersHasGoodsDao ordersHasGoods;
	@Override
	public Integer save(OrdersHasGoods t) throws Exception {
		return ordersHasGoods.save(t);
	}

	@Override
	public Integer update(OrdersHasGoods t) throws Exception {
		return ordersHasGoods.save(t);
	}

	@Override
	public List<OrdersHasGoods> getAll() throws Exception {
		return ordersHasGoods.getAll();
	}

	@Override
	public OrdersHasGoods getOneById(OrdersHasGoods t) throws Exception {
		return ordersHasGoods.getOneById(t);
	}

	@Override
	public Integer deleteOneById(OrdersHasGoods t) throws Exception {
		return ordersHasGoods.deleteOneById(t);
	}

}
