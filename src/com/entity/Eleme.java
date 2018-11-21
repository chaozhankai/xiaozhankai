package com.entity;

/**
 * 新建一个eleme实体类，他的每一个属性都对应着表中的一个字段
 * 也可以理解为每一个eleme对象都对应着数据库中eleme表的一条记录
 */

public class Eleme {
    private int id; // id，唯一标致符号，排序用
    private String link; // 用来存放饿了么红包链接
    private int used; // 记录红包的使用信息，0为未使用，1为使用，当获取链接之后把对应记录的used从0变为1
    private String AddDate; // 录入红包的日期，现在没有使用
    private String LastDate; // 红包过期的日期，由于现在链接没之前那么规范，很难统计，打算未来获取时将此值置为当前日期，便于未来统计
    private String spare; // 空属性，备用，可以用来记录一些备注什么的

    // 下面全为get set，不用看了
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }

    public String getAddDate() {
        return AddDate;
    }

    public void setAddDate(String addDate) {
        AddDate = addDate;
    }

    public String getLastDate() {
        return LastDate;
    }

    public void setLastDate(String lastDate) {
        LastDate = lastDate;
    }

    public String getSpare() {
        return spare;
    }

    public void setSpare(String spare) {
        this.spare = spare;
    }

}
