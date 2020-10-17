/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.model;

import java.util.Date;

/**
 *
 * @author hungpv
 */
public class User {
    private Long id;
    private String username;
    private String password;
    private String avatar;
    private Boolean status;
    private String role;
    private Date createdAt;

    public User(){}

    public User(Long id, String password, String avatar, Boolean status, String role, Date createdAt) {
        this.id = id;
        this.password = password;
        this.avatar = avatar;
        this.status = status;
        this.role = role;
        this.createdAt = createdAt;
    }

    public User(Long id, String username, String password, String avatar, Boolean status, String role, Date createdAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.avatar = avatar;
        this.status = status;
        this.role = role;
        this.createdAt = createdAt;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    
}
