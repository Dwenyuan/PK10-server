package com.pk10.service;

import com.pk10.bean.AccountChange;

import java.util.List;

/**
 * Created by dengfengdecao on 16/10/17.
 */
public interface AccountChangeService extends BaseService<AccountChange> {
    void saveCollection(List<AccountChange> accountChanges);

    List<AccountChange> findByUserId(Integer curUserId);
    List<AccountChange> findByAgentId(Integer agentId);

    List<AccountChange> findByUserIdAndInTime(Integer curUserId, String startTime, String endTime);

    List<AccountChange> findByAgentIdAndInTime(Integer agentId, String startTime, String endTime);

    List<AccountChange> findInTime(String startTime, String endTime);
}
