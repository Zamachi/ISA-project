package com.example.trade_centre.model;

import lombok.Data;

@Data
public class NewsLocalizationsModel {
    private String id;
    private String newsSlug;
    private String title;
    private String description;
    private String content;
    private String contentHTML;
    private String culture;
}