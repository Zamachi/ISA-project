package com.example.trade_centre.service;

import com.example.trade_centre.entity.Item;
import com.example.trade_centre.model.ItemModel;
import com.example.trade_centre.repository.iItemsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service()
public class ItemsService implements iItemsService{

    @Autowired
    private iItemsRepository itemsRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private iUserService userService;

    @Override
    public Item insert(ItemModel itemModel) {

        var owner = userService.findByUsername( itemModel.getOwner().getUsername() ) ;
        itemModel.setOwner(owner);
        itemModel.setBuyer(null);
        itemModel.setSold(false);
        itemModel.setDate_created( LocalDate.now() );
        itemModel.setSlug( (itemModel.getItem_name() + " " + itemModel.getOwner().getUsername() + " " + itemModel.getDate_created().toString() ).toLowerCase().replaceAll("[^a-z0-9]","-")  );

        return itemsRepository.insert(modelMapper.map(itemModel,Item.class));
    }

    @Override
    public List<Item> findAll() {
        return itemsRepository.findAll();
    }
}
