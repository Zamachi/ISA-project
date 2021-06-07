package com.example.trade_centre.service;

import com.example.trade_centre.entity.Trait;
import com.example.trade_centre.model.TraitModel;

import java.util.List;

public interface iTraitService {

    List<Trait> findAll();
    Trait save(TraitModel trait);
    void deleteById(String id);
    Trait insert(TraitModel traitModel);
}
