package com.wen.dao;

import com.wen.entity.Girl;
import org.springframework.stereotype.Repository;

@Repository
public interface GirlMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Girl record);

    int insertSelective(Girl record);

    Girl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Girl record);

    int updateByPrimaryKey(Girl record);
}