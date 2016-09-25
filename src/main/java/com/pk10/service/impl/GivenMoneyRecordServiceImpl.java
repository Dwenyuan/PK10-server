package com.pk10.service.impl;

import com.pk10.bean.GivenMoneyRecord;
import com.pk10.dao.GivenMoneyRecordDao;
import com.pk10.service.GivenMoneyRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by dengfengdecao on 16/9/24.
 */
@Service
@Transactional
public class GivenMoneyRecordServiceImpl implements GivenMoneyRecordService {

    @Resource
    private GivenMoneyRecordDao givenMoneyRecordDao;

    @Override
    public void save(GivenMoneyRecord givenMoneyRecord) {
        givenMoneyRecordDao.save(givenMoneyRecord);
    }
}
