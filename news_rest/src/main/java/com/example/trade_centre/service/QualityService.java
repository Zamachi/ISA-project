package com.example.trade_centre.service;

import com.example.trade_centre.entity.Quality;
import com.example.trade_centre.model.QualityModel;
import com.example.trade_centre.repository.iQualityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class QualityService implements iQualityService{

    @Autowired
    private iQualityRepository qualityRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Quality> findAll() {
        return qualityRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        qualityRepository.deleteById(id);
    }

    @Override
    public Quality insert(QualityModel qualityModel) {
        return qualityRepository.insert( modelMapper.map( qualityModel , Quality.class));
    }

    @Override
    public Quality save(QualityModel quality) {

        var old_quality = qualityRepository.findById( quality.getId() ).get();

        old_quality.setQualityName(quality.getQualityName());
        old_quality.setColor(quality.getColor());

        return qualityRepository.save( modelMapper.map( old_quality, Quality.class ) );
    }
}
