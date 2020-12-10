package com.lazyyy.blog.service;

import com.lazyyy.blog.dao.CategoryDao;
import com.lazyyy.blog.model.Category;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CategoryService {

    private static final Logger LOGGER = LogManager.getLogger(CategoryService.class);
    private static CategoryService categoryService;
    private static final Object MUTEX = new Object();

    private CategoryService() {
    }


    public static CategoryService getInstance() {
        if (categoryService == null) {
            synchronized (MUTEX) {
                if (categoryService == null) {
                    categoryService = new CategoryService();
                }
            }
        }
        return categoryService;
    }

    public List<Category> getAllCategory() {
        return CategoryDao.getInstance().findAll();
    }

    public Category getById(int id) {
        return CategoryDao.getInstance().findById(id);
    }
}
