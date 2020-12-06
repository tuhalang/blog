package com.lazyyy.blog.controller;

import com.lazyyy.blog.model.User;
import com.lazyyy.blog.service.UserService;
import com.lazyyy.blog.utils.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/auth/signIn")
@MultipartConfig
public class SignInController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        User user = UserService.getInstance().login(username, pwd);
        if(user != null){
            SessionUtils.getInstance().putValue(request,"USERNAME", user.getUsername());
            SessionUtils.getInstance().putValue(request,"USER_ID", user.getId());
            response.getWriter().print(200);
            response.getWriter().flush();
        }else{
            response.getWriter().print(404);
            response.getWriter().flush();
        }
    }
}
