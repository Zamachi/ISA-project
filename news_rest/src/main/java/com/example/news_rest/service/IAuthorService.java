package com.example.news_rest.service;

import com.example.news_rest.entity.Author;
import com.example.news_rest.model.AuthorModel;

import java.util.List;

public interface IAuthorService {
    Author insert(AuthorModel model);
    Author insert(Author entity);
    Author findOneBySlug(String slug);
    List<Author> findAll();
    List<Author> findAllBySlug(String slug);
}
