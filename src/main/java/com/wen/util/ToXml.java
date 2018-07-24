package com.wen.util;

import com.wen.entity.Attri;
import com.wen.entity.Data;
import org.jdom.Attribute;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;


import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by Administrator on 2018/6/29.
 */
public class ToXml {

    public void BuildXMLDoc(String url,List<Data> dataList) throws IOException, JDOMException, ClassNotFoundException, IllegalAccessException {
        // 创建根节点 并设置它的属性 ;
        Element root = new Element("DATAPACKET").setAttribute("Version", "2.0");
        //--根节点的子节点
        Element metadata = new Element("METADATA");
        //文档中的FIELD
        //懒得一个一个写实体类，就直接从现有的文件里拿
        List<Attri> attri = getXml.getAttri(url);
        //添加FIELDS
        Element fields = new Element("FIELDS");
        for (Attri attri1 : attri) {
            //增加FIELD节点
            Element field = new Element("FIELD");
            //---添加FIELD的属性
            Attribute attrname = new Attribute("attrname", attri1.getAttrname().toString());
            Attribute fieldtype = new Attribute("fieldtype", attri1.getFieldtype().toString());
            field.setAttribute(attrname).setAttribute(fieldtype);
            if (attri1.getWidth() != null) {
                Attribute width = new Attribute("WIDTH", attri1.getWidth().toString());
                field.setAttribute(width);
            }

            fields.addContent(field);
        }
        metadata.addContent(fields);
        //--文档中有这个节点，
        Element params = new Element("PARAMS");
        metadata.addContent(params);
        //--根节点的子节点
        //--添加数据ROWDATA
        //
        Element rowdata = new Element("ROWDATA");
//        List<Data> data = getXml.getData("C:\\Users\\Administrator\\IdeaProjects\\zd2017-04-067-yl-68.xml");

        Field[] fields1 = new Data().getClass().getDeclaredFields();
        for (Data datum : dataList) {
            Element row = new Element("ROW");
            for (Field field : fields1) {
                field.setAccessible(true);
                if (field.get(datum) != null) {
                    Attribute att = new Attribute(field.getName().toLowerCase(), field.get(datum).toString());
                    row.setAttribute(att);
                }
            }
            rowdata.addContent(row);
        }
        root.addContent(metadata);
        root.addContent(rowdata);
        // 输出 books.xml 文件；
        // 使xml文件 缩进效果
        Format format = Format.getPrettyFormat();
        format.setEncoding("utf-8");
        XMLOutputter XMLOut = new XMLOutputter(format);
        XMLOut.output(root, new FileOutputStream("c:/books.xml"));
    }

    public static void main(String[] args) {
        //文档路径，读取FIELDS
        String url=null;
        //数据
        List<Data> data=null;
        try {
            ToXml j2x = new ToXml();
            System.out.println("正在生成 books.xml 文件...");
            j2x.BuildXMLDoc(url,data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("c:/books.xml 文件已生成");
    }
}
