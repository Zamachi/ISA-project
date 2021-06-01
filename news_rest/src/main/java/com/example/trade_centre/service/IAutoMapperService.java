package com.example.trade_centre.service;

import com.example.trade_centre.entity.Author;
import com.example.trade_centre.model.AuthorModel;

public interface IAutoMapperService {
    Author mapToAuthorEntity(AuthorModel model);
    AuthorModel mapToAuthorModel(Author entity);
    <T> T map(Object model, Class<T> entity);
}
