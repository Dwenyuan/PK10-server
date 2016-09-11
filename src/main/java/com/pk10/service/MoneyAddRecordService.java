package com.pk10.service;

import com.pk10.bean.MoneyAddRecord;

import java.util.List;

/**
 * Created by ron on 16-9-5.
 */
public interface MoneyAddRecordService {

    public List<MoneyAddRecord> getMoneyAddRecordByUserId(int userId);

    public int insertMoneyAddRecord(MoneyAddRecord moneyAddRecord);

    public List<MoneyAddRecord> getAll();
}
