package com.lazyyy.blog.controller;


import com.lazyyy.blog.model.Post;
import com.lazyyy.blog.model.User;
import com.lazyyy.blog.service.PostService;
import com.lazyyy.blog.service.UserService;
import com.lazyyy.blog.utils.SessionUtils;
import org.mindrot.jbcrypt.BCrypt;

import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/secure/profile")
@MultipartConfig
public class ProfileController extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User user = UserService.getInstance().getById((Integer) SessionUtils.getInstance().getValue(req, "USER_ID"));
        List<Post> posts = PostService.getInstance().getPostByUserId((Integer) SessionUtils.getInstance().getValue(req, "USER_ID"), 0, 15);

        String type = req.getParameter("type");

        if (type.equalsIgnoreCase("username")) {
            String newUsername = req.getParameter("newUsername");

            boolean isExist = UserService.getInstance().isExists(newUsername);
            if (!isExist) {
                UserService.getInstance().changeUsername(user.getUsername(), newUsername);
                resp.getWriter().print(200);
                resp.getWriter().flush();
            } else {
                resp.getWriter().print(401);
                resp.getWriter().flush();
            }
        } else if (type.equalsIgnoreCase("password")) {
            String newPassword = req.getParameter("newPassword");
            String oldPassword = req.getParameter("oldPassword");

            if (BCrypt.checkpw(oldPassword, user.getPassword())) {
                UserService.getInstance().changePassword(user.getUsername(), newPassword);
                resp.getWriter().print(200);
                resp.getWriter().flush();
            } else {
                resp.getWriter().print(400);
                resp.getWriter().flush();
            }

        } else {
            String url = req.getParameter("url");

            UserService.getInstance().changeAvatar(user.getUsername(), url);
            resp.getWriter().print(200);
            resp.getWriter().flush();
        }

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
