package com.example.trade_centre.repository;

import com.example.trade_centre.entity.Quality;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface iQualityRepository extends MongoRepository<Quality,String> {
}
