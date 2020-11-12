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
        //String email = request.getParameter("email");

        User user = new User();
        user.setUsername(username);
        user.setPassword(pwd);
        user.setRole("USER");
        user.setStatus(true);

        boolean register = UserService.getInstance().register(user);
        if(register){
            request.setAttribute("IS_REGISTER_SUCCESS", true);
            request.getRequestDispatcher("/views/HomeScreen.jsp").forward(request,response);
        }else{
            request.setAttribute("IS_REGISTER_SUCCESS", false);
            request.getRequestDispatcher("/views/HomeScreen.jsp").forward(request,response);
        }


    }
}
