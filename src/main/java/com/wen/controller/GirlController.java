package com.wen.controller;

import com.wen.entity.Girl;
import com.wen.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2018/7/17.
 */
@Controller
@RequestMapping("/user")
public class GirlController {
    @Autowired
    GirlService girlService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ModelAndView writeSubmitHtml(@PathVariable int id) {
        List<Girl> girl = girlService.selectAll();
        System.out.println(girl.get(0).getCupSize());
        ModelAndView m=new ModelAndView("index.btl");
        m.addObject("girls",girl);
        return m;
    }
}
