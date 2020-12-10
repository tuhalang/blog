package com.lazyyy.blog.controller;

import com.lazyyy.blog.model.Post;
import com.lazyyy.blog.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/posts/search")
public class SearchController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String key = request.getParameter("key");
        int offset = Integer.parseInt(request.getParameter("offset"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        String typeSearch = request.getParameter("type");
        List<Post> posts = null;

        if(typeSearch.equalsIgnoreCase("category")){
           posts = PostService.getInstance().searchByCategory(key, offset, limit);
        }else{
           posts = PostService.getInstance().searchPost(key, offset, limit);
        }

        request.setAttribute("posts", posts);
        request.getRequestDispatcher("/views/PostInstance.jsp").forward(request,response);
    }
}
