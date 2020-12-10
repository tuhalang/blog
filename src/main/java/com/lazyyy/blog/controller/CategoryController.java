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
import java.util.*;
import java.io.IOException;

@WebServlet("/category")
public class CategoryController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Category categ = CategoryService.getInstance().getById(Integer.parseInt(id));
        List<Post> postList = PostService.getInstance().getPostByCategId(categ.getId(), 0, 15);
        request.setAttribute("categ", categ);
        request.setAttribute("posts", postList);
        request.getRequestDispatcher("/views/CategoryScreen.jsp").forward(request, response);
    }
}
