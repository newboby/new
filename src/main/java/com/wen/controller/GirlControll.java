package com.wen.controller;

import com.wen.entity.Book;
import com.wen.entity.Girl;
import com.wen.service.GirlService;
import de.neuland.jade4j.Jade4J;
import de.neuland.jade4j.exceptions.JadeCompilerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/17.
 */
@Controller
@RequestMapping("/user")
public class GirlControll {
    @Autowired
    GirlService girlService;

    @RequestMapping("/id")
    public ModelAndView writeSubmitHtml() {
        Girl girl = girlService.selectAllGirl(1);
        ModelAndView m=new ModelAndView("pages/index");
        m.addObject("girls",girl);
//        ModelAndView mv = new ModelAndView("pages/templates/index");
//        mv.addObject("a", "a");
        return m;
    }

    @RequestMapping(value = "index1")
    public ModelAndView goJadePage() {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("The Hitchhiker's Guide to the Galaxy", 5.70, true));
        books.add(new Book("Life, the Universe and Everything", 5.60, false));
        books.add(new Book("The Restaurant at the End of the Universe", 5.40, true));

        ModelAndView mv = new ModelAndView("pages/templates/index");
        mv.addObject("books", books);
        mv.addObject("pageName", "My Bookshelf");
        return mv;
    }

    @RequestMapping(value = "index2")
    @ResponseBody
    public String goJadePageHtml() {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("The Hitchhiker's Guide to the Galaxy", 5.70, true));
        books.add(new Book("Life, the Universe and Everything", 5.60, false));
        books.add(new Book("The Restaurant at the End of the Universe", 5.40, true));

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("books", books);
        model.put("pageName", "My Bookshelf");

        String html = "";
        try {
            html = Jade4J.render("D:/jade/pages/index.jade", model);
        } catch (JadeCompilerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return html;
    }
}
