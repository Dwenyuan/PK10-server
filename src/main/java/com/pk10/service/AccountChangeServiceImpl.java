package com.pk10.service;

import com.pk10.bean.AccountChange;
import com.pk10.dao.AccountChangeDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dengfengdecao on 16/10/17.
 */
@Service
@Transactional
public class AccountChangeServiceImpl implements AccountChangeService {

    @Resource
    private AccountChangeDao accountChangeDao;

    @Override
    public Integer save(AccountChange accountChange) throws Exception {
        return accountChangeDao.save(accountChange);
    }

    @Override
    public Integer update(AccountChange accountChange) throws Exception {
        return accountChangeDao.update(accountChange);
    }

    @Override
    public List<AccountChange> getAll() throws Exception {
        return accountChangeDao.getAll();
    }

    @Override
    public AccountChange getOneById(AccountChange accountChange) throws Exception {
        return accountChangeDao.getOneById(accountChange);
    }

    @Override
    public Integer deleteOneById(AccountChange accountChange) throws Exception {
        return accountChangeDao.deleteOneById(accountChange);
    }

    @Override
    public void saveCollection(List<AccountChange> accountChanges) {
        accountChangeDao.saveCollection(accountChanges);
    }

    @Override
    public List<AccountChange> findByUserId(Integer curUserId) {
        return accountChangeDao.findByUserId(curUserId);
    }

    @Override
    public List<AccountChange> findByAgentId(Integer agentId) {
        return accountChangeDao.findByAgentId(agentId);
    }

    @Override
    public List<AccountChange> findByUserIdAndInTime(Integer curUserId, String startTime, String endTime) {
        return accountChangeDao.findByUserIdAndInTime(curUserId, startTime, endTime);
    }

    @Override
    public List<AccountChange> findByAgentIdAndInTime(Integer agentId, String startTime, String endTime) {
        return accountChangeDao.findByAgentIdAndInTime(agentId, startTime, endTime);
    }

    @Override
    public List<AccountChange> findInTime(String startTime, String endTime) {
        return accountChangeDao.findInTime(startTime, endTime);
    }
}
