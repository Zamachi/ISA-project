package com.example.trade_centre.repository;

import com.example.trade_centre.entity.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface iItemsRepository extends MongoRepository<Item,String> {

}
