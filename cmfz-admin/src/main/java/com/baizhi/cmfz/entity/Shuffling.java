package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 轮播图的实体类
 * @Author Muzonghao
 * @Date 2018/7/5 19:56
 */
public class Shuffling implements Serializable {
    private String shufflingId;
    private String shufflingPath;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date shufflingDate;
    private String shufflingDescription;
    private String shufflingStatus;

    public String getShufflingId() {
        return shufflingId;
    }

    public void setShufflingId(String shufflingId) {
        this.shufflingId = shufflingId;
    }

    public String getShufflingPath() {
        return shufflingPath;
    }

    public void setShufflingPath(String shufflingPath) {
        this.shufflingPath = shufflingPath;
    }

    public Date getShufflingDate() {
        return shufflingDate;
    }

    public void setShufflingDate(Date shufflingDate) {
        this.shufflingDate = shufflingDate;
    }

    public String getShufflingDescription() {
        return shufflingDescription;
    }

    public void setShufflingDescription(String shufflingDescription) {
        this.shufflingDescription = shufflingDescription;
    }

    public String getShufflingStatus() {
        return shufflingStatus;
    }

    public void setShufflingStatus(String shufflingStatus) {
        this.shufflingStatus = shufflingStatus;
    }

    @Override
    public String toString() {
        return "Shuffling{" +
                "shufflingId='" + shufflingId + '\'' +
                ", shufflingPath='" + shufflingPath + '\'' +
                ", shufflingDate=" + shufflingDate +
                ", shufflingDescription='" + shufflingDescription + '\'' +
                ", shufflingStatus='" + shufflingStatus + '\'' +
                '}';
    }

    public Shuffling() {
    }

    public Shuffling(String shufflingId, String shufflingPath, Date shufflingDate, String shufflingDescription, String shufflingStatus) {

        this.shufflingId = shufflingId;
        this.shufflingPath = shufflingPath;
        this.shufflingDate = shufflingDate;
        this.shufflingDescription = shufflingDescription;
        this.shufflingStatus = shufflingStatus;
    }
}
