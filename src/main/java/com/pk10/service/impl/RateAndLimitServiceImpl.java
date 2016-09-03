package com.pk10.service.impl;

import com.pk10.bean.Betlimit;
import com.pk10.dao.BetlimitMapper;
import com.pk10.service.RateAndLimitService;
import com.sun.javafx.collections.MappingChange;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ron on 16-9-3.
 */
@Service
public class RateAndLimitServiceImpl implements RateAndLimitService {

    @Resource
    BetlimitMapper betlimitMapper;

    //获取0-9的赔率和限制
    @Override
    public Betlimit getRateAndLimitInNum() {
        return null;
    }

    //获取大小单双的赔率和限制
    @Override
    public Betlimit getRateAndLimitInSD() {
        return null;
    }

    //获取大小单双的赔率和限制
    @Override
    public List<Map<String,Betlimit>> getRateAndLimit() {
        List<Map<String,Betlimit>> BList = new ArrayList<Map<String,Betlimit>>();
        Map<String,Betlimit> mMap = new HashMap<String,Betlimit>();
        mMap.put("大小单双",betlimitMapper.selectByPrimaryKey(1));
        BList.add(mMap);
        Map<String,Betlimit> mMap2 = new HashMap<String,Betlimit>();
        mMap2.put("0-9",betlimitMapper.selectByPrimaryKey(2));
        BList.add(mMap2);

        return BList;
    }

    //更新大小单双的赔率和限制
    @Override
    public void updateRateAndLimit(Betlimit betlimit) {
        betlimitMapper.updateByPrimaryKeySelective(betlimit);
    }
}
