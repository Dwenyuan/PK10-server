package com.pk10.dao;

import com.pk10.bean.AccountChange;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by dengfengdecao on 16/10/17.
 */
public interface AccountChangeDao extends BaseDao<AccountChange> {


    void saveCollection(List<AccountChange> accountChanges);

    List<AccountChange> findByUserId(Integer curUserId);

    List<AccountChange> findByUserIdAndInTime(@Param("userId") Integer curUserId,
                                              @Param("startTime") String startTime,
                                              @Param("endTime") String endTime);

    List<AccountChange> findByAgentId(Integer agentId);

    List<AccountChange> findByAgentIdAndInTime(@Param("agentId")Integer agentId,
                                               @Param("startTime") String startTime,
                                               @Param("endTime") String endTime);

    List<AccountChange> findInTime(@Param("startTime") String startTime,
                                   @Param("endTime") String endTime);
}
