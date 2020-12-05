package com.lazyyy.blog.controller;

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
//        Map<String, String> formData = getFormData( request );
//        System.out.println(formData);
        String username = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        boolean isAuth = UserService.getInstance().login(username, pwd);
        if(isAuth){
            SessionUtils.getInstance().putValue(request,"USERNAME", username);
            response.getWriter().print(200);
            response.getWriter().flush();
        }else{
            response.getWriter().print(404);
            response.getWriter().flush();
        }
    }

    private Map<String, String> getFormData(HttpServletRequest request) {
        Map<String, String> parameterMap = request.getParameterMap();
        Map<String, String> collect = parameterMap.entrySet().stream().collect( Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
        return collect;
    }
}
