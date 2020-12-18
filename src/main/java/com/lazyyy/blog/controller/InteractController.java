package com.lazyyy.blog.controller;

import com.lazyyy.blog.service.PostService;
import com.lazyyy.blog.utils.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/secure/interact/like")
@MultipartConfig
public class InteractController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String postIdStr = req.getParameter("postId");
        String typeStr = req.getParameter("type");
        String action = req.getParameter("action");
        if (SessionUtils.getInstance().getValue(req, "USER_ID") == null && action == "check") {
            resp.getWriter().print(false);
            resp.getWriter().flush();
        }
        String userIdStr = SessionUtils.getInstance().getValue(req, "USER_ID").toString();
        Integer userId = Integer.parseInt(userIdStr);
        Integer postId = Integer.parseInt(postIdStr);
        Integer type = Integer.parseInt(typeStr);
        if (action.equals("check")) {
            boolean check = PostService.getInstance().check(userId, postId, type);
            resp.getWriter().print(check);
            resp.getWriter().flush();
        } else if (action.equals("count")) {
            Long count = PostService.getInstance().countLike(postId);
            resp.getWriter().print(count);
            resp.getWriter().flush();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String userIdStr = SessionUtils.getInstance().getValue(req, "USER_ID").toString();
        String postIdStr = req.getParameter("postId");
        String typeStr = req.getParameter("type");
        Integer userId = Integer.parseInt(userIdStr);
        Integer postId = Integer.parseInt(postIdStr);
        Integer type = Integer.parseInt(typeStr);

        PostService.getInstance().like(userId, postId, type);

        Long count = PostService.getInstance().countLike(postId);

        resp.getWriter().print(count);
        resp.getWriter().flush();
    }
}
