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
public class TagDao extends BaseDao {
    private static final Logger LOGGER = LogManager.getLogger(TagDao.class);
    private static TagDao tagDao;
    private static final Object MUTEX = new Object();
    
    private TagDao(){}
    
    
    public static TagDao getInstance(){
        if(tagDao == null){
            synchronized(MUTEX){
                if(tagDao == null){
                    tagDao = new TagDao();
                }
            }
        }
        return tagDao;
    }
}