package com.example.trade_centre.service;

import com.example.trade_centre.entity.Trait;
import com.example.trade_centre.model.TraitModel;
import com.example.trade_centre.repository.iTraitRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class TraitService implements iTraitService {

    @Autowired
    private iTraitRepository traitRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Trait> findAll() {
        return traitRepository.findAll();
    }

    @Override
    public Trait save(TraitModel traitModel) {

        var old_trait = traitRepository.findById(traitModel.getId()).get();

        old_trait.setTraitName(traitModel.getTraitName());


        return traitRepository.save(modelMapper.map(old_trait, Trait.class));
    }

    @Override
    public void deleteById(String id) {
        traitRepository.deleteById(id);
    }

    @Override
    public Trait insert(TraitModel traitModel) {
        return traitRepository.insert(modelMapper.map(traitModel, Trait.class));
    }
}
