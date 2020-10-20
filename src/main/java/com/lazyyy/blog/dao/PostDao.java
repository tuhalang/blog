/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazyyy.blog.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author hungpv
 */
public class PostDao extends BaseDao {
    private static final Logger LOGGER = LogManager.getLogger(PostDao.class);
    private static PostDao postDao;
    private static final Object MUTEX = new Object();
    
    private PostDao(){}
    
    
    public static PostDao getInstance(){
        if(postDao == null){
            synchronized(MUTEX){
                if(postDao == null){
                    postDao = new PostDao();
                }
            }
        }
        return postDao;
    }
}
