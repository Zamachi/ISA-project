package com.example.trade_centre.repository;

import com.example.trade_centre.entity.News;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface INewsRepository extends MongoRepository<News, String> {
    News findBySlug(String slug);
    @Query(value = "{'slug': {$regex : ?0, $options: 'i'}}")
    List<News> findAllBySlug(String slug);
}
