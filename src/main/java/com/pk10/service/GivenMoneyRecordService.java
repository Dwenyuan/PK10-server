package com.pk10.service;

import com.pk10.bean.GivenMoneyRecord;

import java.util.List;

/**
 * Created by dengfengdecao on 16/9/24.
 */
public interface GivenMoneyRecordService {

    void save(GivenMoneyRecord givenMoneyRecord);

    List<GivenMoneyRecord> getGivenMoneyList(String curUsername, String startTime, String endTime);

    List<GivenMoneyRecord> findByBetweenTime(String startTime, String endTime);

    List<GivenMoneyRecord> findAll();

    List<GivenMoneyRecord> getGivenMoneyRecordByUserId(Integer id);
}
