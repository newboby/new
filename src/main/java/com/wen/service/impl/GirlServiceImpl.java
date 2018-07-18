package com.wen.service.impl;

import com.wen.dao.GirlMapper;
import com.wen.entity.Girl;
import com.wen.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/7/17.
 */
@Service
public class GirlServiceImpl implements GirlService {

    @Autowired
    private GirlMapper girlMapper;

    @Override
    public Girl selectAllGirl(Integer id) {
        return girlMapper.selectByPrimaryKey(id);
    }

}
