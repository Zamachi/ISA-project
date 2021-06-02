package com.example.trade_centre.repository;

import com.example.trade_centre.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface iCategoryRepository extends MongoRepository<Category,String> {
    Category findByName(String name);
    List<Category> findAllByParent(Category parent);
    Category findBySlug(String slug);
}
