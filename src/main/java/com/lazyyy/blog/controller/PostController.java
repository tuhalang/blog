package com.lazyyy.blog.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lazyyy.blog.model.Post;
import com.lazyyy.blog.model.User;
import com.lazyyy.blog.service.PostService;
import com.lazyyy.blog.service.UserService;
import com.lazyyy.blog.utils.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/post")
@MultipartConfig
public class PostController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Post post = PostService.getInstance().getPostById(id);
        User user = UserService.getInstance().getById(post.getUserId());
        Long numOfPosts = UserService.getInstance().countPosts(user.getId());
        Long like = PostService.getInstance().countLike(post.getId());
        request.setAttribute("post", post);
        request.setAttribute("owner", user);
        request.setAttribute("numOfPosts", numOfPosts);
        request.setAttribute("numOfLikes", like);
        request.getRequestDispatcher("/views/PostInstance.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String postName = request.getParameter("postName");
        int offset = Integer.parseInt(request.getParameter("offset"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        List<Post> posts = PostService.getInstance().searchPost(postName, offset, limit);

        ObjectMapper objectMapper = new ObjectMapper();
        String listPost = objectMapper.writeValueAsString(posts);

        response.getWriter().print(listPost);
        response.getWriter().flush();

    }
}
