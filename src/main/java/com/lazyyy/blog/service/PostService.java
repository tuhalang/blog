package com.lazyyy.blog.service;

import com.lazyyy.blog.dao.PostDao;
import com.lazyyy.blog.model.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class PostService {

    private static final Logger LOGGER = LogManager.getLogger(PostService.class);
    private static PostService postService;
    private static final Object MUTEX = new Object();

    private PostService() {
    }


    public static PostService getInstance() {
        if (postService == null) {
            synchronized (MUTEX) {
                if (postService == null) {
                    postService = new PostService();
                }
            }
        }
        return postService;
    }

    public List<Post> getLatestPosts(int offset, int limit) {
        return PostDao.getInstance().getTopPosts(offset, limit);
    }

    public Post getPostById(String id) {
        return PostDao.getInstance().searchById(id);
    }

    public boolean savePost(Post post) {
        try {
            PostDao.getInstance().save(post);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
