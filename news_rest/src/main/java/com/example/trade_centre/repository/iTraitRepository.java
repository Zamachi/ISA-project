package com.example.trade_centre.repository;

import com.example.trade_centre.entity.Trait;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface iTraitRepository extends MongoRepository<Trait, String> {
}
