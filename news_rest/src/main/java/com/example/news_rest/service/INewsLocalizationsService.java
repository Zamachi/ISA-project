package com.example.news_rest.service;

import com.example.news_rest.entity.NewsLocalizations;
import com.example.news_rest.model.NewsLocalizationsModel;

import java.util.List;

public interface INewsLocalizationsService {
    NewsLocalizations insert(NewsLocalizations entity);
    List<NewsLocalizations> findAll();
}
