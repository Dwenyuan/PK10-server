package com.pk10.service;

import com.pk10.bean.Betlimit;

import java.util.List;
import java.util.Map;

/**
 * Created by ron on 16-9-3.
 */
public interface RateAndLimitService {

    public Betlimit getRateAndLimitInNum();

    public Betlimit getRateAndLimitInSD();

    public List<Map<String,Betlimit>> getRateAndLimit();

    public void updateRateAndLimit(Betlimit betlimit);
}
