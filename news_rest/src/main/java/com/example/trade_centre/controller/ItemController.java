package com.example.trade_centre.controller;

import com.example.trade_centre.entity.Item;
import com.example.trade_centre.model.ItemModel;
import com.example.trade_centre.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("items")
public class ItemController {

    @Autowired
    private ItemsService itemsService;

    @PostMapping("additem")
    private Item addItem(@RequestBody ItemModel itemModel){
        return itemsService.insert(itemModel);
    }

    @GetMapping("findallitems")
    private List<Item> findAllItems(){
        return itemsService.findAll();
    }

}
