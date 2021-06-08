package com.example.trade_centre.service;

import com.example.trade_centre.entity.User;
import com.example.trade_centre.model.UserModel;

import java.util.List;

public interface iUserService {
    User insert(UserModel model);
    User insert(User entity);
    User findBySlug(String slug);
    User findByUsername(String username);
    List<User> findAll();
    List<User> findAllBySlug(String slug);
    User save(User user);
//    UserModel login(UserModel userModel);
}
