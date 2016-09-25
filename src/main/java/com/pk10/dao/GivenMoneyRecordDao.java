package com.pk10.dao;

import com.pk10.bean.GivenMoneyRecord;
import org.springframework.stereotype.Repository;

/**
 * Created by dengfengdecao on 16/9/24.
 */
@Repository
public interface GivenMoneyRecordDao {

    public void save(GivenMoneyRecord givenMoneyRecord);
}
