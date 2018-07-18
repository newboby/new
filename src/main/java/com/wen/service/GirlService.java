package com.wen.service;

import com.wen.entity.Girl;

import java.util.List;

/**
 * Created by Administrator on 2018/7/17.
 */

public interface GirlService {

    Girl selectAllGirl(Integer id);

    List<Girl> selectAll();
}
