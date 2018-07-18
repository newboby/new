package com.wen.test.dao;

import com.wen.dao.GirlMapper;
import org.apache.ibatis.javassist.ClassPath;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2018/7/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:springmvc-config.xml"})
public class GirlMapperTest {
    @Autowired
    GirlMapper girlMapper;
    @Test
    public void setGirlMapper(){
        System.out.println(girlMapper.selectByPrimaryKey(1));

    }
}
