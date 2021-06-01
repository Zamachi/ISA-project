package com.example.trade_centre.service;

import com.example.trade_centre.entity.NewsLocalizations;

import java.util.List;

public interface INewsLocalizationsService {
    NewsLocalizations insert(NewsLocalizations entity);
    List<NewsLocalizations> findAll();
}
