package com.lazyyy.blog.controller;

import com.lazyyy.blog.model.Post;
import com.lazyyy.blog.service.PostService;
import com.lazyyy.blog.utils.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

@WebServlet("/secure/edit")
@MultipartConfig
public class EditController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/EditScreen.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String content = req.getParameter("content");
        String title = req.getParameter("title");
        String categoryId = req.getParameter("categoryId");
        if (categoryId == "" || title == "" || content == "") {
            resp.getWriter().print(500);
            resp.getWriter().flush();
            return;
        }
        boolean isSave = PostService.getInstance().savePost(new Post(
                (Integer) SessionUtils.getInstance().getValue(req, "USER_ID"),
                Integer.parseInt(categoryId),
                title,
                "",
                "",
                content
        ));
        if (isSave) {
            resp.getWriter().print(200);
            resp.getWriter().flush();
        } else {
            resp.getWriter().print(404);
            resp.getWriter().flush();
        }
    }
}