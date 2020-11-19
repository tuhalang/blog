package com.lazyyy.blog.controller;

import com.lazyyy.blog.service.UserService;
import com.lazyyy.blog.utils.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/auth/signIn")
public class SignInController extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        System.out.println(username+pwd);
        response.getWriter().print("200");
        response.getWriter().flush();

//        System.out.println("successsaaaaa");
//
//        boolean isAuth = UserService.getInstance().login(username, pwd);
//
//        if(isAuth){
//            SessionUtils.getInstance().putValue(request,"USERNAME", username);
//            response.getWriter().print("200");
//            response.getWriter().flush();
//        }else{
//            response.getWriter().print("404");
//            response.getWriter().flush();
//        }
    }
}
