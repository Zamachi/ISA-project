package com.example.trade_centre.repository;


import com.example.trade_centre.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface iUserRepository extends MongoRepository<User, String> {

    User findBySlug(String slug);
    User findByUsername(String username);
    @Query(value = "{'slug': {$regex : ?0, $options: 'i'}}")
    List<User> findAllBySlug(String slug);

}
