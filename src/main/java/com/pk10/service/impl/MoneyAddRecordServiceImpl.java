package com.pk10.service.impl;

import com.pk10.bean.MoneyAddRecord;
import com.pk10.dao.MoneyAddRecordMapper;
import com.pk10.service.MoneyAddRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ron on 16-9-5.
 */
@Service
public class MoneyAddRecordServiceImpl implements MoneyAddRecordService {

    @Resource
    MoneyAddRecordMapper moneyAddRecordMapper;

    @Override
    public List<MoneyAddRecord> getMoneyAddRecordByUserId(int userId) {
        return moneyAddRecordMapper.selectByUserId(userId);
    }

    @Override
    public int insertMoneyAddRecord(MoneyAddRecord moneyAddRecord) {
        return moneyAddRecordMapper.insert(moneyAddRecord);
    }

    @Override
    public List<MoneyAddRecord> getAll() {
        return moneyAddRecordMapper.selectAll();
    }

    @Override
    public void save(MoneyAddRecord moneyAddRecord) {
        moneyAddRecordMapper.insert(moneyAddRecord);
    }

    @Override
    public List<MoneyAddRecord> getMoneyAddRecordList(Integer curUserId, String startTime, String endTime) {
        return moneyAddRecordMapper.getMoneyAddRecordList(curUserId, startTime, endTime);
    }

    @Override
    public List<MoneyAddRecord> findByTimeBetween(String startTime, String endTime) {
        return moneyAddRecordMapper.findByTimeBetween(startTime, endTime);
    }

    @Override
    public List<MoneyAddRecord> findByIdAndTime(Integer id, String startTime, String endTime) {
        return moneyAddRecordMapper.findByIdAndTime(id, startTime, endTime);
    }

    @Override
    public List<MoneyAddRecord> findByAgentIdAndTime(Integer curAgentId, String startTime, String endTime) {
        return moneyAddRecordMapper.findByAgentIdAndTime(curAgentId, startTime, endTime);
    }
}
