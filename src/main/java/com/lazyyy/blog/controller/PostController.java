package com.lazyyy.blog.controller;

import com.lazyyy.blog.model.Post;
import com.lazyyy.blog.model.User;
import com.lazyyy.blog.service.PostService;
import com.lazyyy.blog.service.UserService;
import com.lazyyy.blog.utils.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/post")
public class PostController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Post post = PostService.getInstance().getPostById(id);
        User user = UserService.getInstance().getById(post.getUserId());
        request.setAttribute("post", post);
        request.setAttribute("owner", user);
        request.getRequestDispatcher("/views/PostInstance.jsp").forward(request, response);
    }
}
