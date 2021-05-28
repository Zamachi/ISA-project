package com.example.news_rest.service;

import com.example.news_rest.entity.Author;
import com.example.news_rest.model.AuthorModel;
import org.springframework.context.annotation.Bean;

public interface IAutoMapperService {
    Author mapToAuthorEntity(AuthorModel model);
    AuthorModel mapToAuthorModel(Author entity);
    <T> T map(Object model, Class<T> entity);
}
