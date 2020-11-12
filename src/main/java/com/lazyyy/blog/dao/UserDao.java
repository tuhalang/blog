/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazyyy.blog.dao;

import com.lazyyy.blog.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author hungpv
 */
public class UserDao extends BaseDao{
    
    private static final Logger LOGGER = LogManager.getLogger(UserDao.class);
    private static UserDao userDao;
    private static final Object MUTEX = new Object();
    
    private UserDao(){}
    
    
    public static UserDao getInstance(){
        if(userDao == null){
            synchronized(MUTEX){
                if(userDao == null){
                    userDao = new UserDao();
                }
            }
        }
        return userDao;
    }

    public boolean isExists(String username){
        String sql = "select * from users a where a.username = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            conn = getDefaultConnection();
            ps = conn.prepareStatement(sql);
            ps.setQueryTimeout(120);
            ps.setString(1, username);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            return false;
        } finally {
            closeObject(rs);
            closeObject(ps);
            closeObject(conn);
        }
    }
    
    /**
     * find user by username
     * @param username
     * @return 
     */
    public User findUserByUsername(String username){
        LOGGER.debug("Start findUserByUsername, username: " + username);
        Long startTime = System.currentTimeMillis();
        String sql = "select * from users a where a.username = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            conn = getDefaultConnection();
            ps = conn.prepareStatement(sql);
            ps.setQueryTimeout(120);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if(rs.next()){
                Integer id = rs.getInt("id");
                String password = rs.getString("password");
                String avatar = rs.getString("avatar");
                Boolean status = rs.getBoolean("status");
                Date createdAt = rs.getDate("created_at");
                user = new User(id, username, password, avatar, status, sql, createdAt);
            }else{
                LOGGER.info("Not found user with username: " + username);
            }
        } catch (SQLException ex) {
            LOGGER.error(ex.getMessage(), ex);
        } finally {
            closeObject(rs);
            closeObject(ps);
            closeObject(conn);
        }
        Long endTime = System.currentTimeMillis();
        LOGGER.debug("End findUserByUsername, time execute: " + (endTime - startTime) + " (ms)");
        return user;
    }
    
    /**
     * 
     * @param user
     * @param isEncryptPass 
     */
    public void save(User user, boolean isEncryptPass){
        LOGGER.debug("Start save, isEncryptPass: " + isEncryptPass);
        Long startTime = System.currentTimeMillis();
        if(isEncryptPass){
            user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10)));
        }
        String sql = "insert into users(username, password, avatar, status, role) values(?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = getDefaultConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            if(user.getAvatar() != null){
                ps.setString(3, user.getAvatar());
            }else{
                ps.setNull(3, Types.VARCHAR);
            }
            ps.setBoolean(4, user.getStatus());
            ps.setString(5, user.getRole());
            ps.setQueryTimeout(120);
            ps.executeUpdate();
            conn.commit();
        }catch(SQLException ex){
            LOGGER.error(ex.getMessage(), ex);
            rollback(conn);
        }finally{
            closeObject(ps);
            closeObject(conn);
        }
        Long endTime = System.currentTimeMillis();
        LOGGER.debug("End save, time execute: " + (endTime - startTime) + " (ms)");
    }
}
