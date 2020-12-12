package com.lazyyy.blog.service;

import com.lazyyy.blog.dao.UserDao;
import com.lazyyy.blog.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;

public class UserService {
    private static final Logger LOGGER = LogManager.getLogger(UserService.class);
    private static UserService userService;
    private static final Object MUTEX = new Object();

    private UserService(){}


    public static UserService getInstance(){
        if(userService == null){
            synchronized(MUTEX){
                if(userService == null){
                    userService = new UserService();
                }
            }
        }
        return userService;
    }

    public User login(String uname, String pwd){
        User user = UserDao.getInstance().findUserByUsername(uname);
        if(BCrypt.checkpw(pwd, user.getPassword())){
            return user;
        }
        return null;
    }

    public boolean register(User user) {
        if(!UserDao.getInstance().isExists(user.getUsername())){
            UserDao.getInstance().save(user, true);
            return true;
        }else{
            return false;
        }
    }

    public boolean isExists(String username) {
        return UserDao.getInstance().isExists(username);
    }

    public void changeUsername(String oldUsername, String newUsername) {
        UserDao.getInstance().changeUsername(oldUsername, newUsername);
    }

    public void changePassword(String username, String newPassword) {
        UserDao.getInstance().changePassword(username, newPassword, true);
    }

    public User getById(int id){
        User user = UserDao.getInstance().findUserById(id);
        return user;
    }
}
