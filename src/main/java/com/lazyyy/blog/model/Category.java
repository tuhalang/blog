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
public class Category {
    
    private Integer id;
    private String name;
    private String code;
    private Date createdAt;
    private Integer numOfPosts;
    private String image;

    public Integer getNumOfPosts() {
        return numOfPosts;
    }

    public void setNumOfPosts(Integer numOfPosts) {
        this.numOfPosts = numOfPosts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
