package com.example.trade_centre.controller;

import com.example.trade_centre.entity.News;
import com.example.trade_centre.model.NewsModel;
import com.example.trade_centre.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @PostMapping("insert")
    public News insert(@RequestBody NewsModel model) {
        return newsService.insertNews(model);
    }

    @GetMapping("findall")
    @CrossOrigin(origins = "*")
    public List<News> findAll() {
        return newsService.findAll();
    }



}
