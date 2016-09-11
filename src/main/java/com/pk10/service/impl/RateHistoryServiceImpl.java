package com.pk10.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pk10.bean.Datagrid;
import com.pk10.bean.Page;
import com.pk10.bean.RateHistory;
import com.pk10.dao.RateHistoryMapper;
import com.pk10.service.RateHistoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ron on 16-9-10.
 */
@Service
public class RateHistoryServiceImpl implements RateHistoryService{

    @Resource
    RateHistoryMapper rateHistoryMapper;

    @Override
    public Datagrid getAll(Page page) {
        PageHelper.startPage(page.getPages(),10);
        List<RateHistory> rateHistories = rateHistoryMapper.selectAll();
        PageInfo pageInfo = new PageInfo(rateHistories);
        Datagrid datagrid = new Datagrid();
        datagrid.setRows(rateHistories);
        datagrid.setCurrentPage(page.getPages());
        datagrid.setTotalPage(pageInfo.getPages());
        datagrid.setTotal(pageInfo.getTotal());
        return datagrid;
    }

    @Override
    public List<RateHistory> getRateHistoryByUsername(RateHistory rateHistory) {
        return  rateHistoryMapper.selectByUsername(rateHistory);
    }
}
