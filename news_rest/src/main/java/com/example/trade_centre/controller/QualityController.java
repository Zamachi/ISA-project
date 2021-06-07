package com.example.trade_centre.controller;

import com.example.trade_centre.entity.Category;
import com.example.trade_centre.entity.Quality;
import com.example.trade_centre.model.CategoryModel;
import com.example.trade_centre.model.QualityModel;
import com.example.trade_centre.service.QualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quality")
public class QualityController {

    @Autowired
    private QualityService qualityService;

    @GetMapping("getallqualities")
    @CrossOrigin(origins = "*")
    public List<Quality> findAllQualities(){
        return qualityService.findAll();
    }

    @PostMapping("createquality")
    @CrossOrigin(origins="*")
    private Quality createCategory(@RequestBody QualityModel qualityModel){
        return qualityService.insert(qualityModel);
    }

    @PutMapping("updatequality")
    @CrossOrigin(origins = "*")
    private Quality updateCategory(@RequestBody QualityModel qualityModel){
        return qualityService.save(qualityModel);
    }

    @DeleteMapping("deletequality/{id}")
    @CrossOrigin(origins = "*")
    private void deleteCategory(@PathVariable("id") String id){
        qualityService.deleteById(id);
    }

}
