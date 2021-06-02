package com.example.trade_centre.model;

import com.example.trade_centre.entity.Category;
import com.example.trade_centre.entity.User;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Data
public class ItemModel {

    private String Id;
    private String itemName;
    private Long basePrice;
    private Category category;
    private int amount;
    private int level;
    private User owner;
    private boolean sold;
    private User buyer;
    private LocalDate dateCreated;
    private String slug;

}
