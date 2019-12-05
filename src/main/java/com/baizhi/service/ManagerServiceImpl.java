package com.baizhi.service;

import com.baizhi.dao.ManagerDao;
import com.baizhi.entity.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * author : 张京斗
 * create_date : 2019/10/31 20:17
 * version : 1.0
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerDao managerDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Manager findOne(String name) {
        return managerDao.findOne(name);
    }

    @Override
    public void addOne(Manager manager) {
        managerDao.save(manager);
    }
}
