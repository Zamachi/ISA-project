package com.example.trade_centre.controller;

import com.example.trade_centre.entity.Category;
import com.example.trade_centre.model.CategoryModel;
import com.example.trade_centre.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("createcategory")
    private Category createCategory(@RequestBody CategoryModel categoryModel){
        return categoryService.insert(categoryModel);
    }

    @GetMapping("updatecategory")
    private Category updateCategory(@RequestBody CategoryModel categoryModel){
        return categoryService.update(categoryModel);
    }

    @GetMapping("findallbyparent")
    private List<Category> findAllByParent(@RequestBody CategoryModel categoryModel){
        return categoryService.findAllByParent(categoryModel);
    }

    @GetMapping("findallcategories")
    private List<Category> findAllCategories(){
        return categoryService.findAll();
    }

    @GetMapping("findcategorybyname")
    private Category findCategoryByName(String name){
        return categoryService.findByName(name);
    }

}
