/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazyyy.blog.dao;

import com.lazyyy.blog.model.Category;
import com.lazyyy.blog.model.Post;
//import javafx.geometry.Pos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hungpv
 */
public class PostDao extends BaseDao {
    private static final Logger LOGGER = LogManager.getLogger(PostDao.class);
    private static PostDao postDao;
    private static final Object MUTEX = new Object();

    private PostDao() {
    }


    public static PostDao getInstance() {
        if (postDao == null) {
            synchronized (MUTEX) {
                if (postDao == null) {
                    postDao = new PostDao();
                }
            }
        }
        return postDao;
    }

    public List<Post> searchByName(String key, int offset, int limit) {
        String sql = "select p.*, u.username from posts p inner join users u on u.id = p.user_id where lower(p.title) like concat('%', ?, '%') offset ? limit ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Post> posts = new ArrayList<>();
        try {
            conn = getDefaultConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, key);
            ps.setInt(2, offset);
            ps.setInt(3, limit);
            rs = ps.executeQuery();
            while (rs.next()) {

                Integer id = rs.getInt("id");
                Integer userId = rs.getInt("user_id");
                String title = rs.getString("title");
                String thumbnail = rs.getString("thumbnail");
                String summary = rs.getString("summary");
                String content = rs.getString("content");
                Date createdAt = rs.getDate("created_at");
                Integer categoryId = rs.getInt("category_id");
                String userName = rs.getString("username");

                Post post = new Post();
                post.setId(id);
                post.setUserId(userId);
                post.setCategoryId(categoryId);
                post.setThumbnail(thumbnail);
                post.setTitle(title);
                post.setSummary(summary);
                post.setContent(content);
                post.setCreatedAt(createdAt);
                post.setUserName(userName);

                posts.add(post);
            }

            return posts;
        } catch (SQLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            rollback(conn);
            return null;
        } finally {
            closeObject(ps);
            closeObject(conn);
            closeObject(rs);
        }
    }

    public List<Post> searchByCategId(int categId, int offset, int limit) {
        String sql = "select p.*, u.username from posts p inner join users u on u.id = p.user_id where p.category_id = ? offset ? limit ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Post> posts = new ArrayList<>();
        try {
            conn = getDefaultConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setInt(1, categId);
            ps.setInt(2, offset);
            ps.setInt(3, limit);
            rs = ps.executeQuery();
            while (rs.next()) {

                Integer id = rs.getInt("id");
                Integer userId = rs.getInt("user_id");
                String title = rs.getString("title");
                String thumbnail = rs.getString("thumbnail");
                String summary = rs.getString("summary");
                String content = rs.getString("content");
                Date createdAt = rs.getDate("created_at");
                Integer categoryId = rs.getInt("category_id");
                String userName = rs.getString("username");

                Post post = new Post();
                post.setId(id);
                post.setUserId(userId);
                post.setCategoryId(categoryId);
                post.setThumbnail(thumbnail);
                post.setTitle(title);
                post.setSummary(summary);
                post.setContent(content);
                post.setCreatedAt(createdAt);
                post.setUserName(userName);

                posts.add(post);
            }

            return posts;
        } catch (SQLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            rollback(conn);
            return null;
        } finally {
            closeObject(ps);
            closeObject(conn);
            closeObject(rs);
        }
    }

    public List<Post> searchByUserId(int uid, int offset, int limit) {
        String sql = "select * from posts p where p.user_id = ? offset ? limit ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Post> posts = new ArrayList<>();
        try {
            conn = getDefaultConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setInt(1, uid);
            ps.setInt(2, offset);
            ps.setInt(3, limit);
            rs = ps.executeQuery();
            while (rs.next()) {

                Integer id = rs.getInt("id");
                Integer userId = rs.getInt("user_id");
                String title = rs.getString("title");
                String thumbnail = rs.getString("thumbnail");
                String summary = rs.getString("summary");
                String content = rs.getString("content");
                Date createdAt = rs.getDate("created_at");
                Integer categoryId = rs.getInt("category_id");

                Post post = new Post();
                post.setId(id);
                post.setUserId(userId);
                post.setCategoryId(categoryId);
                post.setThumbnail(thumbnail);
                post.setTitle(title);
                post.setSummary(summary);
                post.setContent(content);
                post.setCreatedAt(createdAt);

                posts.add(post);
            }

            return posts;
        } catch (SQLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            rollback(conn);
            return null;
        } finally {
            closeObject(ps);
            closeObject(conn);
            closeObject(rs);
        }
    }

    public Post findById(String postId) {
        String sql = "select p.*, u.username from posts p inner join users u on u.id = p.user_id where p.id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Post> posts = new ArrayList<>();
        try {
            conn = getDefaultConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(postId));
            rs = ps.executeQuery();
            while (rs.next()) {

                Integer id = rs.getInt("id");
                Integer userId = rs.getInt("user_id");
                String title = rs.getString("title");
                String thumbnail = rs.getString("thumbnail");
                String summary = rs.getString("summary");
                String content = rs.getString("content");
                Date createdAt = rs.getDate("created_at");
                Integer categoryId = rs.getInt("category_id");
                String username = rs.getString("username");

                Post post = new Post();
                post.setId(id);
                post.setUserId(userId);
                post.setCategoryId(categoryId);
                post.setThumbnail(thumbnail);
                post.setTitle(title);
                post.setSummary(summary);
                post.setContent(content);
                post.setCreatedAt(createdAt);
                post.setUserName(username);

                posts.add(post);
            }

            return posts.get(0);
        } catch (SQLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            rollback(conn);
            return null;
        } finally {
            closeObject(ps);
            closeObject(conn);
            closeObject(rs);
        }
    }

    public List<Post> searchByCategory(String key, int offset, int limit) {
        String sql = "select * from posts inner join category c on c.id = posts.category_id " +
                "where lower(c.name) like concat('%', ?, '%') offset ? limit ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Post> posts = new ArrayList<>();
        try {
            conn = getDefaultConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, key);
            ps.setInt(2, offset);
            ps.setInt(3, limit);
            rs = ps.executeQuery();
            while (rs.next()) {

                Integer id = rs.getInt("id");
                Integer userId = rs.getInt("user_id");
                String title = rs.getString("title");
                String thumbnail = rs.getString("thumbnail");
                String summary = rs.getString("summary");
                String content = rs.getString("content");
                Date createdAt = rs.getDate("created_at");
                Integer categoryId = rs.getInt("category_id");

                Post post = new Post();
                post.setId(id);
                post.setUserId(userId);
                post.setCategoryId(categoryId);
                post.setThumbnail(thumbnail);
                post.setTitle(title);
                post.setSummary(summary);
                post.setContent(content);
                post.setCreatedAt(createdAt);

                posts.add(post);
            }

            return posts;
        } catch (SQLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            rollback(conn);
            return null;
        } finally {
            closeObject(ps);
            closeObject(conn);
            closeObject(rs);
        }
    }

    public void like(Integer userId, Integer postId, Integer type) {
        String sql = "insert into interact(post_id, user_id, type) values (?, ?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getDefaultConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setInt(1, postId);
            ps.setInt(2, userId);
            ps.setInt(3, type);
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            rollback(conn);
        } finally {
            closeObject(ps);
            closeObject(conn);
        }
    }

    public boolean check(Integer userId, Integer postId, Integer type) {
        String sql = "select * from interact i where i.user_id = ? & i.post_id = ? & i.type = ?";

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            conn = getDefaultConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setInt(2, postId);
            ps.setInt(3, type);
            rs = ps.executeQuery();
            if (rs.next()) return true;
            else return false;
        } catch (SQLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            rollback(conn);
            return false;
        } finally {
            closeObject(ps);
            closeObject(conn);
            return true;
        }
    }

    public Long countLike(Integer postId) {
        String sql = "select count(*) as count from interact where post_id = ? and type = 1";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Long count = 0l;
        try {
            conn = getDefaultConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setInt(1, postId);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getLong("count");
            }
        } catch (SQLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            rollback(conn);
            return 0l;
        } finally {
            closeObject(ps);
            closeObject(conn);
            closeObject(rs);
        }
        return count;
    }


    public List<Post> getPosts(Integer categoryId, int offset, int limit) {
        String sql = "select * from posts p where p.category_id = ? offset ? limit ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Post> posts = new ArrayList<>();
        try {
            conn = getDefaultConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setInt(1, categoryId);
            ps.setInt(2, offset);
            ps.setInt(3, limit);
            rs = ps.executeQuery();
            while (rs.next()) {

                Integer id = rs.getInt("id");
                Integer userId = rs.getInt("user_id");
                String title = rs.getString("title");
                String thumbnail = rs.getString("thumbnail");
                String summary = rs.getString("summary");
                String content = rs.getString("content");
                Date createdAt = rs.getDate("created_at");

                Post post = new Post();
                post.setId(id);
                post.setUserId(userId);
                post.setCategoryId(categoryId);
                post.setThumbnail(thumbnail);
                post.setTitle(title);
                post.setSummary(summary);
                post.setContent(content);
                post.setCreatedAt(createdAt);

                posts.add(post);
            }

            return posts;
        } catch (SQLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            rollback(conn);
            return null;
        } finally {
            closeObject(ps);
            closeObject(conn);
            closeObject(rs);
        }
    }

    public List<Post> getTopPosts(int offset, int limit) {
        String sql = "select * from posts p order by p.created_at desc offset ? limit ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Post> posts = new ArrayList<>();
        try {
            conn = getDefaultConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setInt(1, offset);
            ps.setInt(2, limit);
            rs = ps.executeQuery();
            while (rs.next()) {

                Integer id = rs.getInt("id");
                Integer userId = rs.getInt("user_id");
                Integer categoryId = rs.getInt("category_id");
                String title = rs.getString("title");
                String thumbnail = rs.getString("thumbnail");
                String summary = rs.getString("summary");
                String content = rs.getString("content");
                Date createdAt = rs.getDate("created_at");

                Post post = new Post();
                post.setId(id);
                post.setUserId(userId);
                post.setCategoryId(categoryId);
                post.setThumbnail(thumbnail);
                post.setTitle(title);
                post.setSummary(summary);
                post.setContent(content);
                post.setCreatedAt(createdAt);

                posts.add(post);
            }

            return posts;
        } catch (SQLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            rollback(conn);
            return null;
        } finally {
            closeObject(ps);
            closeObject(conn);
            closeObject(rs);
        }
    }


    public Long save(Post post) {
        String sql = "insert into posts (category_id, content, summary, thumbnail, title, user_id)\n" +
                "values (?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Long key = -1l;
        try {
            conn = getDefaultConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, post.getCategoryId());
            ps.setString(2, post.getContent());
            ps.setString(3, post.getSummary());
            ps.setString(4, post.getThumbnail());
            ps.setString(5, post.getTitle());
            ps.setInt(6, post.getUserId());
            ps.executeUpdate();
            conn.commit();

            rs = ps.getGeneratedKeys();
            if(rs.next()){
                key = rs.getLong(1);
            }

        } catch (SQLException ex) {
            LOGGER.error(ex.getMessage(), ex);
            rollback(conn);
        } finally {
            closeObject(ps);
            closeObject(conn);
            closeObject(rs);
        }
        return key;
    }
}
