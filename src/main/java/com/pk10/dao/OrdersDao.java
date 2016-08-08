package com.pk10.dao;

import java.util.List;

import com.pk10.bean.Orders;
import com.pk10.bean.UserInfo;

public interface OrdersDao extends BaseDao<Orders> {
	public List<Orders> getListByOpenId(UserInfo userInfo) throws Exception;
}
