package com.example.news_rest.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.List;

@Data
public class AuthorModel {
    private String id;
    private List<TagsModel> tags;
    private String slug;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dateBirth;
    private String city;
    private String country;
}
