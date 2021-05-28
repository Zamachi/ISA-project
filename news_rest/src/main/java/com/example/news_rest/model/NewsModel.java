package com.example.news_rest.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
