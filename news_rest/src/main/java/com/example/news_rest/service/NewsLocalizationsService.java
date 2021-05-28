package com.example.news_rest.service;

import com.example.news_rest.entity.NewsLocalizations;
import com.example.news_rest.model.NewsLocalizationsModel;
import com.example.news_rest.repository.INewsLocalizationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsLocalizationsService implements INewsLocalizationsService {
    @Autowired
    private INewsLocalizationsRepository newsLocalizationsRepository;

    @Override
    public NewsLocalizations insert(NewsLocalizations entity){
        return newsLocalizationsRepository.insert(entity);
    }

    @Override
    public List<NewsLocalizations> findAll() {
        return newsLocalizationsRepository.findAll();
    }
}
