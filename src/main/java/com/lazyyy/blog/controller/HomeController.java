package com.lazyyy.blog.controller;

import com.lazyyy.blog.model.Category;
import com.lazyyy.blog.model.Post;
import com.lazyyy.blog.service.CategoryService;
import com.lazyyy.blog.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int offset = 0;
        int size = 10;
        List<Post> latestPosts = PostService.getInstance().getLatestPosts(offset, size);
        List<Category> categories = CategoryService.getInstance().getAllCategory();
        request.setAttribute("latestPost", latestPosts);
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/views/HomeScreen.jsp").forward(request,response);
    }
}
