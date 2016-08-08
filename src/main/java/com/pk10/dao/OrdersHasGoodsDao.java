package com.pk10.dao;

import com.pk10.bean.Orders;
import com.pk10.bean.OrdersHasGoods;

public interface OrdersHasGoodsDao extends BaseDao<OrdersHasGoods> {
	public Integer save(Orders orders) throws Exception;
}
