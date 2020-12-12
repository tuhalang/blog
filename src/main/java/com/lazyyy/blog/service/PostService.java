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
        return PostDao.getInstance().findById(id);
    }

    public List<Post> getPostByCategId(int categId, int offset, int limit) {
        return PostDao.getInstance().searchByCategId(categId, offset, limit);
    }

    public List<Post> getPostByUserId(int userId, int offset, int limit) {
        return PostDao.getInstance().searchByUserId(userId, offset, limit);
    }

    public boolean savePost(Post post) {
        try {
            PostDao.getInstance().save(post);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<Post> searchPost(String key, int offset, int limit) {
        try {
            List<Post> search = PostDao.getInstance().searchByName(key, offset, limit);
            return search;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }

    public List<Post> searchByCategory(String key, int offset, int limit) {
        try {
            List<Post> search = PostDao.getInstance().searchByCategory(key, offset, limit);
            return search;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }

}
