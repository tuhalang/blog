package com.lazyyy.blog.filter;

import com.lazyyy.blog.utils.SessionUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String servletPath = request.getServletPath();
        if(servletPath.startsWith("/secure")){
            Object usernameObj = SessionUtils.getInstance().getValue(request, "USERNAME");
            if(usernameObj != null ){
                filterChain.doFilter(servletRequest, servletResponse);
            }else{
                servletResponse.getWriter().print(401);
                servletResponse.getWriter().flush();
            }
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
