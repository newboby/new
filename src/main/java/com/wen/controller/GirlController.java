package com.wen.controller;

import com.sun.deploy.net.HttpResponse;
import com.wen.entity.Girl;
import com.wen.service.GirlService;
import com.wen.util.ExcelUtil;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by Administrator on 2018/7/17.
 */
@Controller
@RequestMapping("/user")
public class GirlController {
    @Autowired
    GirlService girlService;

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ModelAndView writeSubmitHtml(@RequestParam int id, HttpSession session) {
        List<Girl> girls = girlService.selectAll();
        Girl girl = girlService.selectAllGirl(id);
        if (girl != null) {
            session.setAttribute("user", girl);
        }
        System.out.println(girl);
        ModelAndView m = new ModelAndView("index.btl");
        m.addObject("girls", girls);
        m.addObject("user", girl);
        return m;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam int age, @RequestParam Integer cpuSize, @RequestParam Double money) {
        int add = girlService.add(new Girl(age, cpuSize.toString(), money));
        if (add != 0) {
            return "redirect:all";
        }
        return "error";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView all() {
        List<Girl> girls = girlService.selectAll();
        ModelAndView m = new ModelAndView("index.btl");
        m.addObject("girls", girls);
        return m;
    }

    @RequestMapping(value = "/getX")
    public void getXslx(HttpServletResponse response) throws IOException {
//        OutputStream outputStream = response.getOutputStream();
//        response.reset();
//        response.setHeader("Content-disposition","attachment;           filename=temp.xls");
//        response.setContentType("application/msexcel");
//        WritableWorkbook wk= Workbook.createWorkbook(outputStream);
//        WritableSheet sheet=wk.createSheet("成绩表", 0);
        HSSFWorkbook text =
                ExcelUtil.getHSSFWorkbook("text", new String[]{"id", "name"},
                        new String[][]{{"1", "xx"}, {"1", "xx"}, {"1", "xx"}, {"1", "xx"}}, new HSSFWorkbook());
        OutputStream outputStream = response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=details.xls");
        response.setContentType("application/msexcel");
        text.write(outputStream);
        outputStream.close();
    }
}
