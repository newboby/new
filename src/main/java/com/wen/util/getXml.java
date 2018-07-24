package com.wen.util;

import com.wen.entity.Attri;
import com.wen.entity.Data;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;


import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/29.
 */
public class getXml {
    public static Element getElement(String str) throws IOException, JDOMException {
        SAXBuilder sax = new SAXBuilder();
        Document document = sax.build(new FileInputStream(str));
        Element rootElement = document.getRootElement();
        return rootElement;
    }

    public static List<Attri> getAttri(String str) {

        List<Attri> attris = new ArrayList<Attri>();
        try {

            Element rootElement=getElement(str);
            System.out.println(rootElement.getChild("METADATA").getChild("FIELDS").getChildren().size());
            List<Element> children = rootElement.getChild("METADATA").getChild("FIELDS").getChildren();

            for (Element child : children) {
                Attri attri = new Attri();
                attri.setAttrname(child.getAttribute("attrname").getValue());
                attri.setFieldtype(child.getAttributeValue("fieldtype").toString());
                if (child.getAttribute("WIDTH") != null) {
                    attri.setWidth(child.getAttributeValue("WIDTH").toString());
                }
                attris.add(attri);
            }
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return attris;
    }



    //获取ROWDATA的数据
    public static List<Data> getData(String str) {
        List<Data> data=new ArrayList<Data>();
        Data d = new Data();
        Field[] fields = d.getClass().getDeclaredFields();
        try {
            Element rootElement =getElement(str);
            List<Element> rowdata = rootElement.getChild("ROWDATA").getChildren();
            System.out.println(rowdata.size());
            for (Element rowdatum : rowdata) {
                Data data1=new Data();
                for (Field field : fields) {
                    field.setAccessible(true);
                    if (rowdatum.getAttribute(field.getName().toLowerCase()) != null) {
                        field.set(data1, rowdatum.getAttribute(field.getName().toLowerCase()).getValue().toString());
                    }

                }
                data.add(data1);

            }
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
//        System.out.println(data.get(0).toString());
        return data;
    }

//    public static void main(String[] args) {
////        List<Attri> attri = getAttri("C:\\Users\\Administrator\\IdeaProjects\\zd2017-04-067-yl-68.xml");
//        List<Data> data = getData("C:\\Users\\Administrator\\IdeaProjects\\zd2017-04-067-yl-68.xml");
//
////        System.out.println(attri.size());
////        for (Attri attri1 : attri) {
////            System.out.println(attri1.getAttrname().toString());
////        }
//
//    }
}
