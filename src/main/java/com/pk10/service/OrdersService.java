package com.pk10.service;

import java.util.List;

import com.pk10.bean.Orders;
import com.pk10.bean.UserInfo;

public interface OrdersService extends BaseService<Orders>{
	public List<Orders> getListByOpenId(UserInfo userInfo) throws Exception;

	public Integer save(Orders t, UserInfo u) throws Exception;
}
