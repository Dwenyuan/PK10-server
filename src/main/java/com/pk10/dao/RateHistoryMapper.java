package com.pk10.dao;

import com.pk10.bean.RateHistory;
import com.pk10.bean.RateHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RateHistoryMapper {
    int countByExample(RateHistoryExample example);

    int deleteByExample(RateHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RateHistory record);

    int insertSelective(RateHistory record);

    List<RateHistory> selectByExample(RateHistoryExample example);

    RateHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RateHistory record, @Param("example") RateHistoryExample example);

    int updateByExample(@Param("record") RateHistory record, @Param("example") RateHistoryExample example);

    int updateByPrimaryKeySelective(RateHistory record);

    int updateByPrimaryKey(RateHistory record);

    List<RateHistory> selectAll();

    List<RateHistory> selectByUsername(RateHistory rateHistory);
}