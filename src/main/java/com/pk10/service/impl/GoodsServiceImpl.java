package com.pk10.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk10.bean.Goods;
import com.pk10.dao.GoodsDao;
import com.pk10.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsDao goodsDao;

	@Override
	public Integer save(Goods t) throws Exception {
		Integer update = goodsDao.update(t);
		if (update == 0) {
			return goodsDao.save(t);
		}
		return update;
	}

	@Override
	public Integer update(Goods t) throws Exception {
		return goodsDao.update(t);
	}

	@Override
	public List<Goods> getAll() throws Exception {
		return goodsDao.getAll();
	}

	@Override
	public Goods getOneById(Goods t) throws Exception {
		return goodsDao.getOneById(t);
	}

	@Override
	public Integer deleteOneById(Goods t) throws Exception {
		return goodsDao.deleteOneById(t);
	}

}
