package com.wen.entity;

/**
 * Created by Administrator on 2018/7/17.
 */
public class Book {
    private String str;
    private Double age;
    private Boolean a;

    public Book(String str, Double age, Boolean a) {
        this.str = str;
        this.age = age;
        this.a = a;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public Boolean getA() {
        return a;
    }

    public void setA(Boolean a) {
        this.a = a;
    }
}
