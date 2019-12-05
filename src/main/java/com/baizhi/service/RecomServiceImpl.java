package com.baizhi.service;

import com.baizhi.dao.RecomDao;
import com.baizhi.entity.Recom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author : 张京斗
 * create_date : 2019/11/6 21:24
 * version : 1.0
 */
@Service
@Transactional
public class RecomServiceImpl implements RecomService {

    @Autowired
    private RecomDao recomDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Recom> findByUserId(String userid) {
        return recomDao.findByUserId(userid);
    }

    @Override
    public List<Recom> findTheFirsts(String userid) {
        return recomDao.findTheFirsts(userid);
    }

    @Override
    public Recom findByUserIdAndName(String userid, String name) {
        return recomDao.findByUserIdAndName(userid,name);
    }

    @Override
    public void addOne(String id, String name, Integer counts, String uid) {
        recomDao.addOne(id, name, counts, uid);
    }

    @Override
    public void updateOne(String id, String name, Integer counts, String uid) {
        recomDao.updateOne(id, name, counts, uid);
    }
}
