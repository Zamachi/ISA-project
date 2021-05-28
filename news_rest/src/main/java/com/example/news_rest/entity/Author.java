package com.example.news_rest.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.List;

@Data
@Document(collection = "authors")
public class Author {
    @Id
    private String id;
    @Field("tags")
    private List<Tags> tags;
    @Field("slug")
    private String slug;
    @Field("first_name")
    private String firstName;
    @Field("username")
    private String username;
    @Field("password")
    private String password;
    @Field("last_name")
    private String lastName;
    @Field("date_birth")
    private LocalDate dateBirth;
    @Field("city")
    private String city;
    @Field("country")
    private String country;
}
