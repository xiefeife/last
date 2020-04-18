package com.tomlive.entity;

import java.util.Date;

public class PressSort {
    private Integer id;

    private String pressName;

    private String pressDescribe;

    private Date createTime;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPressName() {
        return pressName;
    }

    public void setPressName(String pressName) {
        this.pressName = pressName == null ? null : pressName.trim();
    }

    public String getPressDescribe() {
        return pressDescribe;
    }

    public void setPressDescribe(String pressDescribe) {
        this.pressDescribe = pressDescribe == null ? null : pressDescribe.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}