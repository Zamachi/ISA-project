package com.example.news_rest.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Tags {
    @Id
    private String id;
    private String name;
    private String name_search;
}
