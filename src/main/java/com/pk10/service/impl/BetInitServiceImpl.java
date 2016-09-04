package com.pk10.service.impl;

import com.pk10.bean.BetInit;
import com.pk10.dao.BetInitMapper;
import com.pk10.service.BetInitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by ron on 16-9-3.
 */
@Service
public class BetInitServiceImpl implements BetInitService{

    @Resource
    BetInitMapper betInitMapper;

    @Override
    public List<BetInit> getAllBetInit() {
        return betInitMapper.selectAll();
    }

    @Override
    public int updateBetInit(BetInit betInit) {
        return betInitMapper.updateByPrimaryKeySelective(betInit);
    }

    @Override
    public List<BetInit> getBetInitByName(BetInit betInit) {
        return betInitMapper.selectByGameName(betInit);
    }

	@Override
	public Integer saveBetInit(BetInit betInit) {
		return betInitMapper.insert(betInit);
	}
}
