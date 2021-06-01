package com.example.trade_centre.repository;

import com.example.trade_centre.entity.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface IAuthorRepository extends MongoRepository<Author, String> {
    Author findBySlug(String slug);
    Author findByUsername(String username);
    @Query(value = "{'slug': {$regex : ?0, $options: 'i'}}")
    List<Author> findAllBySlug(String slug);
}
