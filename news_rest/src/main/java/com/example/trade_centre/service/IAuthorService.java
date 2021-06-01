package com.example.trade_centre.service;

import com.example.trade_centre.entity.Author;
import com.example.trade_centre.model.AuthorModel;

import java.util.List;

public interface IAuthorService {
    Author insert(AuthorModel model);
    Author insert(Author entity);
    Author findOneBySlug(String slug);
    List<Author> findAll();
    List<Author> findAllBySlug(String slug);
}
