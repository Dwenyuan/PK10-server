package com.pk10.dao;

import com.pk10.bean.GivenMoneyRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dengfengdecao on 16/9/24.
 */
@Repository
public interface GivenMoneyRecordDao {

    public void save(GivenMoneyRecord givenMoneyRecord);

    List<GivenMoneyRecord> getGivenMoneyList(@Param("curUsername") String curUsername,
                                             @Param("startTime") String startTime,
                                             @Param("endTime") String endTime);
}
