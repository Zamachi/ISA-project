package com.example.trade_centre.service;

import com.example.trade_centre.entity.NewsLocalizations;
import com.example.trade_centre.repository.INewsLocalizationsRepository;
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
