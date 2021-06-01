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
    private String Id;
    @Field("item_name")
    private String item_name;
    @Field("base_price")
    private Long base_price;
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
    @Field("date_created")
    private LocalDate date_created;
    @Field("slug")
    private String slug;
}
