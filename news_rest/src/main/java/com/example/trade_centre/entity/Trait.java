package com.example.trade_centre.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "traits")
public class Trait {
    @Id
    private String id;
    @Field("traitName")
    private String traitName;

}
