package com.example.trade_centre.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class NewsModel {
    private String id;
    private List<TagsModel> tags;
    private String slug;
    private LocalDate datePublish;
    private Long numberOfVisits;
    private AuthorModel author;
    private NewsLocalizationsModel newsLocalizations;
}
