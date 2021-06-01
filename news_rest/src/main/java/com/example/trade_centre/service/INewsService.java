package com.example.trade_centre.service;

import com.example.trade_centre.entity.News;
import com.example.trade_centre.model.NewsModel;

import java.util.List;

public interface INewsService {
    News insert(NewsModel model);
    News findOneBySlug(String slug);
    List<News> findAll();
    List<News> findAllBySlug(String slug);
    News insertNews(NewsModel model);
}
