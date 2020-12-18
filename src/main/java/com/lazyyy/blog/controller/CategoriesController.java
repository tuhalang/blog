package com.lazyyy.blog.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lazyyy.blog.model.Category;
import com.lazyyy.blog.model.Post;
import com.lazyyy.blog.service.CategoryService;
import com.lazyyy.blog.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/categories")
@MultipartConfig
public class CategoriesController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        List<Category> categoryList = CategoryService.getInstance().getAllCategory();
        request.setAttribute("categoryList", categoryList);
        request.getRequestDispatcher("/views/CategoriesScreen.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String categoryName = request.getParameter("categoryName");

        List<Category> categories = CategoryService.getInstance().getByName(categoryName);

        ObjectMapper objectMapper = new ObjectMapper();
        String listPost = objectMapper.writeValueAsString(categories);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(listPost);
        response.getWriter().flush();
    }
}