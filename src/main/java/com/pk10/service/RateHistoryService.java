package com.pk10.service;

import com.pk10.bean.Datagrid;
import com.pk10.bean.Page;
import com.pk10.bean.RateHistory;

import java.util.List;

/**
 * Created by ron on 16-9-10.
 */
public interface RateHistoryService {

    public Datagrid getAll(Page page);

    public List<RateHistory> getRateHistoryByUsername(RateHistory rateHistory);
}
