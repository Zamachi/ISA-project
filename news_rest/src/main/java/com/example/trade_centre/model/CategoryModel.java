package com.example.trade_centre.model;

import com.example.trade_centre.entity.Category;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class CategoryModel {
    private String id;
    private String name;
    private String slug;
    private Category parent;
}
