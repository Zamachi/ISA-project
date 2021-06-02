package com.example.trade_centre.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.List;

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
    @Field("dateCreated")
    private LocalDate dateCreated;
    @Field("country")
    private String country;
    @Field("goldAmount")
    private Long goldAmount;
    @Field("isActive")
    private boolean isActive;
    @Field("userRoles")
    private List<Roles> userRoles;

}
