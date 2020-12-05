package com.lazyyy.blog.controller;

import com.lazyyy.blog.model.Post;
import com.lazyyy.blog.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/secure/edit")
public class EditController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/EditScreen.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String content = req.getParameter("content");
//        String pwd = req.getParameter("pwd");
        PostService.getInstance().savePost(new Post(

        ));
        if(true){
            resp.getWriter().print(200);
            resp.getWriter().flush();
        }else{
            resp.getWriter().print(404);
            resp.getWriter().flush();
        }
    }
}