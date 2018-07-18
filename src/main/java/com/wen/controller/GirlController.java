package com.wen.controller;

import com.wen.entity.Girl;
import com.wen.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
        Girl girl = girlService.selectAllGirl(id);
        ModelAndView m=new ModelAndView("index.btl");
//        System.out.println("success");
        m.addObject("girls",girl);
//        ModelAndView mv = new ModelAndView("pages/templates/index");
//        mv.addObject("a", "a");
        return m;
    }

//    @RequestMapping(value = "index1")
//    public ModelAndView goJadePage() {
//        List<Book> books = new ArrayList<Book>();
//        books.add(new Book("The Hitchhiker's Guide to the Galaxy", 5.70, true));
//        books.add(new Book("Life, the Universe and Everything", 5.60, false));
//        books.add(new Book("The Restaurant at the End of the Universe", 5.40, true));
//
//        ModelAndView mv = new ModelAndView("pages/templates/index");
//        mv.addObject("books", books);
//        mv.addObject("pageName", "My Bookshelf");
//        return mv;
//    }
//
//    @RequestMapping(value = "index2")
//    @ResponseBody
//    public String goJadePageHtml() {
//        List<Book> books = new ArrayList<Book>();
//        books.add(new Book("The Hitchhiker's Guide to the Galaxy", 5.70, true));
//        books.add(new Book("Life, the Universe and Everything", 5.60, false));
//        books.add(new Book("The Restaurant at the End of the Universe", 5.40, true));
//
//        Map<String, Object> model = new HashMap<String, Object>();
//        model.put("books", books);
//        model.put("pageName", "My Bookshelf");
//
//        String html = "";
//        try {
//            html = Jade4J.render("D:/jade/pages/index.jade", model);
//        } catch (JadeCompilerException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return html;
//    }
}
