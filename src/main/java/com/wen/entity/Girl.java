package com.wen.entity;

public class Girl {
    private Integer id;

    private Integer age;

    private String cupSize;

    private Double money;

    public Girl(Integer id, Integer age, String cupSize, Double money) {
        this.id = id;
        this.age = age;
        this.cupSize = cupSize;
        this.money = money;
    }

    public Girl() {
    }

    public Girl(Integer age, String cupSize, Double money) {
        this.age = age;
        this.cupSize = cupSize;
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize == null ? null : cupSize.trim();
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", age=" + age +
                ", cupSize='" + cupSize + '\'' +
                ", money=" + money +
                '}';
    }
}