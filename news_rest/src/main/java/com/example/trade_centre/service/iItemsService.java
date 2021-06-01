package com.example.trade_centre.service;

import com.example.trade_centre.entity.Item;
import com.example.trade_centre.model.ItemModel;

import java.util.List;

public interface iItemsService {

    Item insert(ItemModel itemModel);
    List<Item> findAll();
}
