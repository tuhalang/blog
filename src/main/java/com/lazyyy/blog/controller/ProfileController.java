package com.lazyyy.blog.controller;


import com.lazyyy.blog.model.Post;
import com.lazyyy.blog.model.User;
import com.lazyyy.blog.service.PostService;
import com.lazyyy.blog.service.UserService;
import com.lazyyy.blog.utils.SessionUtils;

import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/secure/profile")
public class ProfileController extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User user = UserService.getInstance().getById((Integer) SessionUtils.getInstance().getValue(req, "USER_ID"));
        List<Post> posts = PostService.getInstance().getPostByUserId((Integer) SessionUtils.getInstance().getValue(req, "USER_ID"), 0, 15);
        req.setAttribute("user", user);
        req.setAttribute("posts", posts);
        req.getRequestDispatcher("/views/ProfileScreen.jsp").forward(req, resp);
    }
}
