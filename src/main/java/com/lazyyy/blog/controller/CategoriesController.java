package com.lazyyy.blog.controller;

import com.lazyyy.blog.model.Category;
import com.lazyyy.blog.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/categories")
public class CategoriesController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Category> categoryList = CategoryService.getInstance().getAllCategory();
        request.setAttribute("categoryList", categoryList);
        request.getRequestDispatcher("/views/CategoriesScreen.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String categoryName = request.getParameter("categoryName");

        List<Category> categoryList = CategoryService.getInstance().getByName(categoryName);
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("categoryName", categoryName);

        request.getRequestDispatcher("/views/CategoriesScreen.jsp").forward(request, response);
    }
}