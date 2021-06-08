package com.example.trade_centre.service;

import com.example.trade_centre.entity.Item;
import com.example.trade_centre.model.ItemModel;

import java.util.List;
import java.util.Map;

public interface iItemsService {

    Item insert(ItemModel itemModel);
    List<Item> findAll();
    List<Item> findAllBySlug(String slug);
    List<Item> findAllByItemName(String ItemName);
    Item update(ItemModel model);
    Item buyItem(String username, String item_id);
    List<Item> findAllItems();
    List<ItemModel> findAllByBuyer(String username);
    List<ItemModel> findAllByComplex(Map<String,String> criteria);
}
