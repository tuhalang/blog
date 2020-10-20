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
}
