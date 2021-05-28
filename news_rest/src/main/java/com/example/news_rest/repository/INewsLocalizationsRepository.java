package com.example.news_rest.repository;

import com.example.news_rest.entity.NewsLocalizations;
import com.example.news_rest.model.NewsLocalizationsModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface INewsLocalizationsRepository extends MongoRepository<NewsLocalizations, String> {
}
