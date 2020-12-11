/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazyyy.blog.model;

import java.util.Date;

/**
 *
 * @author hungpv
 */
public class Post {
    private Integer id;
    private Integer userId;
    private Integer categoryId;
    private String title;
    private String thumbnail;
    private String summary;
    private String content;
    private String image;
    private Date createdAt;

    private String userName;

    public Post() {
    }

    public Post(Integer id, Integer userId, Integer categoryId, String title, String thumbnail, String summary, String content, String image, Date createdAt) {
        this.id = id;
        this.userId = userId;
        this.categoryId = categoryId;
        this.title = title;
        this.thumbnail = thumbnail;
        this.summary = summary;
        this.content = content;
        this.image = image;
        this.createdAt = createdAt;
    }

    public Post(Integer userId, Integer categoryId, String title, String thumbnail, String summary, String content, String image, Date createdAt) {
        this.userId = userId;
        this.categoryId = categoryId;
        this.title = title;
        this.thumbnail = thumbnail;
        this.summary = summary;
        this.content = content;
        this.image = image;
        this.createdAt = createdAt;
    }

    public Post(Integer userId, Integer categoryId, String title, String thumbnail, String summary, String content) {
        this.userId = userId;
        this.categoryId = categoryId;
        this.title = title;
        this.thumbnail = thumbnail;
        this.summary = summary;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
