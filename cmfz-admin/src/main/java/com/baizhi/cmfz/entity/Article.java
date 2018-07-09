package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 文章的实体类
 * @Author Muzonghao
 * @Date 2018/7/8 22:22
 */
public class Article implements Serializable {
    private String articleId;
    private String articleName;
    private String articleIntroduction;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date articleDate;
    private String articleSrc;
    private String guruId;
    private String articleStatus;

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleIntroduction() {
        return articleIntroduction;
    }

    public void setArticleIntroduction(String articleIntroduction) {
        this.articleIntroduction = articleIntroduction;
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }

    public String getArticleSrc() {
        return articleSrc;
    }

    public void setArticleSrc(String articleSrc) {
        this.articleSrc = articleSrc;
    }

    public String getGuruId() {
        return guruId;
    }

    public void setGuruId(String guruId) {
        this.guruId = guruId;
    }

    public String getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(String articleStatus) {
        this.articleStatus = articleStatus;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", articleName='" + articleName + '\'' +
                ", articleIntroduction='" + articleIntroduction + '\'' +
                ", articleDate=" + articleDate +
                ", articleSrc='" + articleSrc + '\'' +
                ", guruId='" + guruId + '\'' +
                ", articleStatus='" + articleStatus + '\'' +
                '}';
    }

    public Article(String articleId, String articleName, String articleIntroduction, Date articleDate, String articleSrc, String guruId, String articleStatus) {
        this.articleId = articleId;
        this.articleName = articleName;
        this.articleIntroduction = articleIntroduction;
        this.articleDate = articleDate;
        this.articleSrc = articleSrc;
        this.guruId = guruId;
        this.articleStatus = articleStatus;
    }

    public Article() {

    }
}
