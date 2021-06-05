package com.example.trade_centre.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "qualities")
public class Quality {
    @Id
    private String id;
    @Field("qualityName")
    private String qualityName;
    @Field("color")
    private String color;
}
