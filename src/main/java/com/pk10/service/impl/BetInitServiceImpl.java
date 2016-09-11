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
        BetInit myBetInit = betInitMapper.selectByGnameAndGtype(betInit);
        myBetInit.setgName(betInit.getgName());
        myBetInit.setType(betInit.getType());
        myBetInit.setInitMoney(betInit.getInitMoney());
        myBetInit.setRate(betInit.getRate());
        myBetInit.setMoneyLimit(betInit.getMoneyLimit());
        return betInitMapper.updateByPrimaryKeySelective(myBetInit);
    }

    @Override
    public List<BetInit> getBetInitByName(BetInit betInit) {
        return betInitMapper.selectByGameName(betInit);
    }

    @Override
    public List<BetInit> getAllGname() {
        return betInitMapper.selectAllGameName();
    }

    @Override
    public List<BetInit> getAllGameTypeByGname(String gName) {
        return betInitMapper.selectAllTypeByGName(gName);
    }

    @Override
    public BetInit getBetinitByNameAndType(BetInit betInit) {
        return betInitMapper.selectByGnameAndGtype(betInit);
    }

    @Override
    public Integer saveBetInit(BetInit betInit) {
        return betInitMapper.insert(betInit);
    }

    @Override
    public BetInit getOneBetInitByName(BetInit betInit) {
        return betInitMapper.getOneBetInitByName(betInit);
    }

}
