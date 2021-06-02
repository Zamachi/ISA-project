package com.example.trade_centre.service;

import com.example.trade_centre.entity.Category;
import com.example.trade_centre.model.CategoryModel;
import com.example.trade_centre.repository.iCategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.util.List;
import java.util.Locale;

@Service()
public class CategoryService implements iCategoryService{

    @Autowired
    private iCategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Category insert(Category category) {
        return categoryRepository.insert(category);
    }

    @Override
    public Category insert(CategoryModel category) {

        var parent = category.getParent();

        category.setSlug( parent == null ? category.getName():(parent.getName()+"-"+category.getName() ).toLowerCase()  );
        category.setName( category.getName().toLowerCase() );

        return categoryRepository.insert( modelMapper.map(category, Category.class) );
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> findAllByParent(Category parent) {
        return categoryRepository.findAllByParent(parent);
    }

    @Override
    public List<Category> findAllBySlug(String slug) {
        return null;
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public Category findBySlug(String slug) {
        return categoryRepository.findBySlug(slug);
    }

    @Override
    public List<Category> findAllByParent(CategoryModel parent) {
        return categoryRepository.findAllByParent( modelMapper.map( parent, Category.class) );
    }

    @Override
    public Category update(CategoryModel categoryModel) {

        var old_category = categoryRepository.findByName(categoryModel.getName() );



        return categoryRepository.save( modelMapper.map(old_category,Category.class) );
    }
}
