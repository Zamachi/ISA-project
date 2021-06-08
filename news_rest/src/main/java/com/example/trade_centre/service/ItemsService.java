package com.example.trade_centre.service;

import com.example.trade_centre.entity.Item;
import com.example.trade_centre.model.ItemModel;
import com.example.trade_centre.repository.iItemsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service()
public class ItemsService implements iItemsService{

    @Autowired
    private iItemsRepository itemsRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Item insert(ItemModel itemModel) {

        var owner = userService.findByUsername( itemModel.getOwner().getUsername() ) ;
        itemModel.setOwner(owner);
        itemModel.setBuyer(null);
        itemModel.setSold(false);
        itemModel.setDateCreated( LocalDate.now() );
        itemModel.setSlug( (itemModel.getItemName() + " " + itemModel.getOwner().getUsername() + " " + itemModel.getDateCreated().toString() ).toLowerCase().replaceAll("[^a-z0-9]","-")  );

        return itemsRepository.insert(modelMapper.map(itemModel,Item.class));
    }

    @Override
    public List<Item> findAll() {
        return itemsRepository.findAll();
    }

    @Override
    public List<Item> findAllBySlug(String slug) {
        return itemsRepository.findAllBySlug(slug);
    }

    @Override
    public List<Item> findAllByItemName(String ItemName) {
        return itemsRepository.findAllByItemName(ItemName);
    }

    @Override
    public Item update(ItemModel model) {

        var old_model = itemsRepository.findById( model.getId() );


        return itemsRepository.save( modelMapper.map(old_model, Item.class) );
    }

    @Override
    public Item buyItem(String username, String id) {

        var old_item = itemsRepository.findById( id );
        Item new_item = null;
        if(old_item.isPresent())
            new_item = old_item.get();


        var buyer = userService.findByUsername(username);
        new_item.setSold( true );
        new_item.setBuyer( buyer );

        buyer.setGoldAmount(buyer.getGoldAmount() - new_item.getBasePrice() * new_item.getAmount() );

        userService.save(buyer);

        return itemsRepository.save( new_item );
    }

    @Override
    public List<Item> findAllItems() {
        return itemsRepository.findAllByIsActive();
    }

    @Override
    public List<ItemModel> findAllByBuyer(String username) {

        var moji_itemi = itemsRepository.findAllByBuyer(username);

        List<ItemModel> to_return = moji_itemi.stream().map(item -> modelMapper.map(item, ItemModel.class)).collect(Collectors.toList());

        return to_return;
    }

    @Override
    public List<ItemModel> findAllByComplex(Map<String, String> criteria) {

        Query query = new Query();

        query.addCriteria(Criteria.where("sold").is(false));

        if(!criteria.get("search").equals(""))
            query.addCriteria(Criteria.where("itemName").regex( criteria.get("search") ) );

        if( !criteria.get("category").toLowerCase().equals("any") )
            query.addCriteria(Criteria.where("category.name").regex( criteria.get("category") ));

        if( !criteria.get("trait").toLowerCase().equals("any") )
            query.addCriteria(Criteria.where("trait.traitName").regex( criteria.get("trait") ));

        if( !criteria.get("quality").toLowerCase().equals("any") )
            query.addCriteria(Criteria.where("quality.qualityName").regex( criteria.get("quality") ));

        query.addCriteria(Criteria.where("level").lt( Integer.parseInt(criteria.get("levelHigh"))+1).gt( Integer.parseInt( criteria.get("levelLow"))-1));
        query.addCriteria(Criteria.where("amount").lt( Integer.parseInt(criteria.get("amountHigh"))+1 ).gt( Integer.parseInt(criteria.get("amountLow"))-1));
        query.addCriteria(Criteria.where("basePrice").lt( Integer.parseInt(criteria.get("priceHigh"))+1 ).gt( Integer.parseInt(criteria.get("priceLow"))-1 ) );

        var results = mongoTemplate.find(query, Item.class);

        return results.stream().map( item -> modelMapper.map(item, ItemModel.class) ).collect(Collectors.toList());
    }
}
