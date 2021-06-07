package com.example.trade_centre.repository;

import com.example.trade_centre.entity.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface iItemsRepository extends MongoRepository<Item,String> {
    @Query(value = "{ slug : {$regex : ?0, $options: 'i'} }")
    List<Item> findAllBySlug(String slug);
    @Query(value = "{ itemName : {$regex : ?0, $options: 'i'} }")
    List<Item> findAllByItemName(String ItemName);
    @Query(value = "{ sold: false }")
    List<Item> findAllByIsActive();
    @Query(value = "{ 'buyer.username': ?0 }")
    List<Item> findAllByBuyer(String username);

}
