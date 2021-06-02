package com.example.trade_centre.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collation = "roles")
public class Roles {
    @Id
    private String id;
    @Field("roleName")
    private String roleName;
}
