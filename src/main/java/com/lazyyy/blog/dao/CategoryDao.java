/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazyyy.blog.dao;

import com.lazyyy.blog.model.Category;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hungpv
 */
public class CategoryDao extends BaseDao{
    private static final Logger LOGGER = LogManager.getLogger(CategoryDao.class);
    private static CategoryDao categoryDao;
    private static final Object MUTEX = new Object();
    
    private CategoryDao(){}
    
    
    public static CategoryDao getInstance(){
        if(categoryDao == null){
            synchronized(MUTEX){
                if(categoryDao == null){
                    categoryDao = new CategoryDao();
                }
            }
        }
        return categoryDao;
    }

    public List<Category> searchByName(String key){
        String sql = "select c.*, (select count(*) from posts p where p.category_id = c.id) as num_of_posts from category c where lower(c.name) like CONCAT('%', ?, '%')";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Category> categories = new ArrayList<>();
        try{
            conn = getDefaultConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, key);
            rs = ps.executeQuery();
            while(rs.next()){

                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String code = rs.getString("code");
                Date createdAt = rs.getDate("created_at");
                Integer numOfPosts = rs.getInt("num_of_posts");

                Category category = new Category();
                category.setId(id);
                category.setName(name);
                category.setCode(code);
                category.setCreatedAt(createdAt);
                category.setNumOfPosts(numOfPosts);

                categories.add(category);
            }

            return categories;
        }catch(SQLException ex){
            LOGGER.error(ex.getMessage(), ex);
            rollback(conn);
            return null;
        }finally{
            closeObject(ps);
            closeObject(conn);
            closeObject(rs);
        }
    }

    public Category findById(int categId){
        String sql = "select c.*,(select count(*) from posts p where p.category_id = c.id) as num_of_posts from category c where c.id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Category> categories = new ArrayList<>();
        try{
            conn = getDefaultConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setInt(1, categId);
            rs = ps.executeQuery();
            while(rs.next()){

                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String code = rs.getString("code");
                Date createdAt = rs.getDate("created_at");
                Integer numOfPosts = rs.getInt("num_of_posts");

                Category category = new Category();
                category.setId(id);
                category.setName(name);
                category.setCode(code);
                category.setCreatedAt(createdAt);
                category.setNumOfPosts(numOfPosts);

                categories.add(category);
            }

            return categories.get(0);
        }catch(SQLException ex){
            LOGGER.error(ex.getMessage(), ex);
            rollback(conn);
            return null;
        }finally{
            closeObject(ps);
            closeObject(conn);
            closeObject(rs);
        }
    }

    public List<Category> findAll(){
        String sql = "select c.*, (select count(*) from posts p where p.category_id = c.id) as num_of_posts from category c ;";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Category> categories = new ArrayList<>();
        try{
            conn = getDefaultConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){

                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String code = rs.getString("code");
                Date createdAt = rs.getDate("created_at");
                Integer numOfPosts = rs.getInt("num_of_posts");

                Category category = new Category();
                category.setId(id);
                category.setName(name);
                category.setCode(code);
                category.setCreatedAt(createdAt);
                category.setNumOfPosts(numOfPosts);

                categories.add(category);
            }

            return categories;
        }catch(SQLException ex){
            LOGGER.error(ex.getMessage(), ex);
            rollback(conn);
            return null;
        }finally{
            closeObject(ps);
            closeObject(conn);
            closeObject(rs);
        }

    }
}
