package com.pk10.dao;

import com.pk10.bean.MoneyAddRecord;
import com.pk10.bean.MoneyAddRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MoneyAddRecordMapper {
    int countByExample(MoneyAddRecordExample example);

    int deleteByExample(MoneyAddRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MoneyAddRecord record);

    int insertSelective(MoneyAddRecord record);

    List<MoneyAddRecord> selectByExample(MoneyAddRecordExample example);

    MoneyAddRecord selectByPrimaryKey(Integer id);

    MoneyAddRecord selectByUserId(Integer id);

    int updateByExampleSelective(@Param("record") MoneyAddRecord record, @Param("example") MoneyAddRecordExample example);

    int updateByExample(@Param("record") MoneyAddRecord record, @Param("example") MoneyAddRecordExample example);

    int updateByPrimaryKeySelective(MoneyAddRecord record);

    int updateByPrimaryKey(MoneyAddRecord record);
}