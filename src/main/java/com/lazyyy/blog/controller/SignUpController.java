package com.lazyyy.blog.controller;

import com.lazyyy.blog.model.User;
import com.lazyyy.blog.service.UserService;
import com.lazyyy.blog.utils.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/auth/signUp")
public class SignUpController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        System.out.println(username);
        User user = new User();
        user.setUsername(username);
        user.setPassword(pwd);
        user.setRole("USER");
        user.setStatus(true);

        boolean register = UserService.getInstance().register(user);
        if (register) {
            request.setAttribute("IS_REGISTER_SUCCESS", true);
            response.getWriter().print("200");
            response.getWriter().flush();
        } else {
            request.setAttribute("IS_REGISTER_SUCCESS", false);
            response.getWriter().print("404");
            response.getWriter().flush();
        }


    }
}
