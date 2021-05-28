package com.example.news_rest.service;

import com.example.news_rest.entity.News;
import com.example.news_rest.model.NewsModel;

import java.util.List;

public interface INewsService {
    News insert(NewsModel model);
    News findOneBySlug(String slug);
    List<News> findAll();
    List<News> findAllBySlug(String slug);
    News insertNews(NewsModel model);
}
