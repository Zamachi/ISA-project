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
    @CrossOrigin(origins="*")
    private Item addItem(@RequestBody ItemModel itemModel){
        return itemsService.insert(itemModel);
    }

    @GetMapping("findallitems")
    @CrossOrigin(origins="*")
    private List<Item> findAllItems(){
        return itemsService.findAll();
    }

    @GetMapping("finditemsbyslug")
    @CrossOrigin(origins = "*")
    private List<Item> findAllBySlug(String slug){
        return itemsService.findAllBySlug(slug);
    }

    @GetMapping("finditemsbyname/{ItemName}")
    @CrossOrigin(origins = "*")
    private List<Item> findAllByItemName(@PathVariable("ItemName") String ItemName) {
        return itemsService.findAllByItemName(ItemName);
    }

    @PostMapping("updateitem")
    @CrossOrigin(origins = "*")
    private Item update(@RequestBody ItemModel itemModel){
        return itemsService.update(itemModel);
    }

}
