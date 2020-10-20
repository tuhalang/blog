/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazyyy.blog.dao;

import com.lazyyy.blog.database.ConnectionPoolManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author hungpv
 */
public class BaseDao {
    
    private static final Logger LOGGER = LogManager.getLogger(BaseDao.class);
    private static final String DEFAULT_PATH_CONFIG = "";
    private static final String DEFAULT_DB_NAME = "";
    
    protected Connection getDefaultConnection(){
        Connection conn = ConnectionPoolManager.getConnection(DEFAULT_DB_NAME);
        if(conn == null){
            ConnectionPoolManager.loadConfig(DEFAULT_PATH_CONFIG);
            conn = ConnectionPoolManager.getConnection(DEFAULT_DB_NAME);
        }
        return conn;
    }
    
    protected void rollback(Connection conn){
        if(conn != null){
            try{
                conn.rollback();
            }catch(SQLException ex){
                LOGGER.error(ex.getMessage(), ex);
            }
        }
    }
    
    protected void closeObject(ResultSet obj){
        if(obj != null){
            try {
                obj.close();
            } catch (SQLException ex) {
                LOGGER.error(ex.getMessage(), ex);
            }
        }
    }
    
    protected void closeObject(PreparedStatement obj){
        if(obj != null){
            try {
                obj.close();
            } catch (SQLException ex) {
                LOGGER.error(ex.getMessage(), ex);
            }
        }
    }
    
    protected void closeObject(Statement obj){
        if(obj != null){
            try {
                obj.close();
            } catch (SQLException ex) {
                LOGGER.error(ex.getMessage(), ex);
            }
        }
    }
    
    protected void closeObject(Connection obj){
        if(obj != null){
            try {
                obj.close();
            } catch (SQLException ex) {
                LOGGER.error(ex.getMessage(), ex);
            }
        }
    }
}
