package com.example.trade_centre.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "news_localizations")
public class NewsLocalizations {
    @Id
    private String id;
    @Field("news_slug")
    private String newsSlug;
    @Field("title")
    private String title;
    @Field("description")
    private String description;
    @Field("content")
    private String content;
    @Field("content_html")
    private String contentHTML;
    @Field("culture")
    private String culture;
}
