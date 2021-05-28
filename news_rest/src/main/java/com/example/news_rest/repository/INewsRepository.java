package com.example.news_rest.repository;

import com.example.news_rest.entity.Author;
import com.example.news_rest.entity.News;
import com.example.news_rest.model.NewsModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface INewsRepository extends MongoRepository<News, String> {
    News findBySlug(String slug);
    @Query(value = "{'slug': {$regex : ?0, $options: 'i'}}")
    List<News> findAllBySlug(String slug);
}
