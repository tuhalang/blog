/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author hungpv
 */
public class CommentDao extends BaseDao{
    private static final Logger LOGGER = LogManager.getLogger(CommentDao.class);
    private static CommentDao commentDao;
    private static final Object MUTEX = new Object();
    
    private CommentDao(){}
    
    
    public static CommentDao getInstance(){
        if(commentDao == null){
            synchronized(MUTEX){
                if(commentDao == null){
                    commentDao = new CommentDao();
                }
            }
        }
        return commentDao;
    }
}
