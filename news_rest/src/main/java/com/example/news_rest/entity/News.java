package com.example.news_rest.entity;

import com.example.news_rest.model.AuthorModel;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "news")
public class News {
    @Id
    private String id;
    @Field("tags")
    private List<Tags> tags;
    @Field("slug")
    private String slug;
    @Field("date_publish")
    private LocalDate datePublish;
    @Field("number_of_visits")
    private Long numberOfVisits;
    @Field("author")
    private Author author;
    @Field("news_localizations")
    private NewsLocalizations newsLocalizations;
}
