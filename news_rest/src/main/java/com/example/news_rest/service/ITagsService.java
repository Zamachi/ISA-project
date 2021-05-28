package com.example.news_rest.service;

import com.example.news_rest.entity.Tags;
import com.example.news_rest.model.AuthorModel;
import com.example.news_rest.model.NewsModel;
import com.example.news_rest.model.TagsModel;

import java.util.List;

public interface ITagsService {
    List<TagsModel> generateAuthorTags(AuthorModel model);
    List<TagsModel> generateNewsTags(NewsModel model);
}
