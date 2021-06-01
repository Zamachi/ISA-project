package com.example.trade_centre.model;

import lombok.Data;

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
