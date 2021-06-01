package com.example.trade_centre.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection="categories")
public class Category {
    @Id
    private String id;
    @Field("name")
    private String name;
    @Field("slug")
    private String slug;
    @Field("parent")
    private Category parent;
}
