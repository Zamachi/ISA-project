package com.example.trade_centre.controller;

import com.example.trade_centre.entity.Category;
import com.example.trade_centre.model.CategoryModel;
import com.example.trade_centre.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("createcategory")
    @CrossOrigin(origins="*")
    private Category createCategory(@RequestBody CategoryModel categoryModel){
        return categoryService.insert(categoryModel);
    }

    @PutMapping("updatecategory")
    @CrossOrigin(origins="*")
    private Category updateCategory(@RequestBody CategoryModel categoryModel){
        return categoryService.update(categoryModel);
    }

    @GetMapping("findallbyparent")
    private List<Category> findAllByParent(@RequestBody CategoryModel categoryModel){
        return categoryService.findAllByParent(categoryModel);
    }

    @GetMapping("findallcategories")
    @CrossOrigin(origins="*")
    private List<Category> findAllCategories(){
        return categoryService.findAll();
    }

    @GetMapping("findcategorybyname")
    @CrossOrigin(origins="*")
    private Category findCategoryByName( String name){
        return categoryService.findByName(name);
    }

    @DeleteMapping("deletecategorybyid/{id}")
    @CrossOrigin(origins="*")
    private void deleteCategoryById(@PathVariable("id")  String id){
        categoryService.deleteById(id);
    }

}
