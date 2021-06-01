package com.example.trade_centre.service;

import com.example.trade_centre.entity.Category;
import com.example.trade_centre.model.CategoryModel;

import java.util.List;

public interface iCategoryService {

    Category insert(Category category);
    Category insert(CategoryModel category);
    List<Category> findAll();
    List<Category> findAllByParent(Category parent);
    List<Category> findAllBySlug(String slug);
    Category findByName(String name);
    Category findBySlug(String slug);
    List<Category> findAllByParent(CategoryModel parent);
    Category update(CategoryModel categoryModel);
}
