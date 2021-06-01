package com.example.trade_centre.service;

import com.example.trade_centre.model.AuthorModel;
import com.example.trade_centre.model.NewsModel;
import com.example.trade_centre.model.TagsModel;

import java.util.List;

public interface ITagsService {
    List<TagsModel> generateAuthorTags(AuthorModel model);
    List<TagsModel> generateNewsTags(NewsModel model);
}
