package com.example.trade_centre.controller;

import com.example.trade_centre.entity.Quality;
import com.example.trade_centre.entity.Trait;
import com.example.trade_centre.model.QualityModel;
import com.example.trade_centre.model.TraitModel;
import com.example.trade_centre.service.QualityService;
import com.example.trade_centre.service.TraitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("traits")
public class TraitController {

    @Autowired
    private TraitService traitService;

    @GetMapping("getalltraits")
    @CrossOrigin(origins = "*")
    public List<Trait> findAllTraits(){
        return traitService.findAll();
    }

    @PostMapping("createtrait")
    @CrossOrigin(origins="*")
    private Trait createCategory(@RequestBody TraitModel traitModel){
        return traitService.insert(traitModel);
    }

    @PutMapping("updatetrait")
    @CrossOrigin(origins = "*")
    private Trait updateCategory(@RequestBody TraitModel traitModel){
        return traitService.save(traitModel);
    }

    @DeleteMapping("deletetrait/{id}")
    @CrossOrigin(origins = "*")
    private void deleteTraitById(@PathVariable("id") String id){
        traitService.deleteById(id);
    }

}
