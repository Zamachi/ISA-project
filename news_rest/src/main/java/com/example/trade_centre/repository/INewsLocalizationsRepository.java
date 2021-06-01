package com.example.trade_centre.repository;

import com.example.trade_centre.entity.NewsLocalizations;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface INewsLocalizationsRepository extends MongoRepository<NewsLocalizations, String> {
}
