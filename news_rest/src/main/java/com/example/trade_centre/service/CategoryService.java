package com.example.trade_centre.service;

import com.example.trade_centre.entity.Category;
import com.example.trade_centre.model.CategoryModel;
import com.example.trade_centre.repository.iCategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.apache.logging.log4j.util.Strings.isEmpty;
import static org.apache.logging.log4j.util.Strings.isNotEmpty;


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
        Category parent=null;
        if( category.getParent() != null ) {
            parent = findCategoryById(category.getParent().getId());
            category.setParent(parent);
        }

        category.setSlug( parent == null ? category.getName():(parent.getName()+"-"+category.getName() ).toLowerCase()  );

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

        //NOTE: basically must exist
        var old_category = categoryRepository.findById(categoryModel.getId()).get();

        old_category.setName( categoryModel.getName() );

        Category parent=null;
        if( categoryModel.getParent() != null ) {
            parent = findCategoryById(categoryModel.getParent().getId());
            old_category.setParent(parent);
        }

        old_category.setSlug( parent == null ? old_category.getName():(parent.getName()+"-"+old_category.getName() ).toLowerCase()  );

        return categoryRepository.save( modelMapper.map(old_category,Category.class) );
    }

    @Override
    public void deleteById(String id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category findCategoryById(String Id) {

        var result = categoryRepository.findById(Id);

        if(result.isEmpty())
            return null;

        return result.get();
    }
}
