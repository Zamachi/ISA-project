package com.example.trade_centre.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    @Field("slug")
    private String slug;
    @Field("username")
    private String username;
    @Field("password")
    private String password; 
    @Field("email")
    private String email;
    @Field("date_created")
    private LocalDate date_created;
    @Field("country")
    private String country;
    @Field("gold_amount")
    private Long gold_amount;
    @Field("is_active")
    private boolean is_active;

}
