package com.example.trade_centre.controller;

import com.example.trade_centre.entity.Item;
import com.example.trade_centre.model.ItemModel;
import com.example.trade_centre.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
        return itemsService.findAllItems();
    }

    @GetMapping("findall")
    @CrossOrigin(origins="*")
    private List<Item> findAll(){
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

    @PostMapping("buyitem")
    @CrossOrigin(origins = "*")
    private Item buyItem(@RequestBody Map< String, String> json){
        var username = json.get("username");
        var item_id = json.get("item_id");
        return itemsService.buyItem(username,item_id);
    }

    @GetMapping("fetchuserpurchases/{username}")
    @CrossOrigin(origins = "*")
    private List<ItemModel> findAllByBuyer(@PathVariable("username") String username){
        return itemsService.findAllByBuyer(username);
    }

    @PostMapping("complexsearch")
    @CrossOrigin(origins = "*")
    private List<ItemModel> complexSearch(@RequestBody Map<String, String> json){
        return itemsService.findAllByComplex(json);
    }

}
