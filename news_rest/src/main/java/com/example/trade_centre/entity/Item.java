package com.example.trade_centre.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Data
@Document(collection = "items")
public class Item {

    @Id
    private String id;
    @Field("itemName")
    private String itemName;
    @Field("basePrice")
    private Long basePrice;
    @Field("category")
    private Category category;
    @Field("amount")
    private int amount;
    @Field("level")
    private int level;
    @Field("owner")
    private User owner;
    @Field("sold")
    private boolean sold;
    @Field("buyer")
    private User buyer;
    @Field("dateCreated")
    private LocalDate dateCreated;
    @Field("slug")
    private String slug;
    @Field("trait")
    private Trait trait;
    @Field("quality")
    private Quality quality;
}
