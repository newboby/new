package com.wen.entity;

/**
 * Created by Administrator on 2018/6/29.
 */
public class Attri {
    private String attrname;
    private String fieldtype;
    private String width;

    public Attri() {
    }

    public Attri(String attrname, String fieldtype, String width) {
        this.attrname = attrname;
        this.fieldtype = fieldtype;
        this.width = width;
    }

    public void setAttrname(String attrname) {
        this.attrname = attrname;
    }

    public void setFieldtype(String fieldtype) {
        this.fieldtype = fieldtype;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getAttrname() {

        return attrname;
    }

    public String getFieldtype() {
        return fieldtype;
    }

    public String getWidth() {
        return width;
    }
}
