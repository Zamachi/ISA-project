package com.example.trade_centre.service;

import com.example.trade_centre.entity.Quality;
import com.example.trade_centre.model.QualityModel;

import java.util.List;

public interface iQualityService {
    List<Quality> findAll();
    Quality save(QualityModel quality);
    void deleteById(String id);
    Quality insert(QualityModel qualityModel);
}
