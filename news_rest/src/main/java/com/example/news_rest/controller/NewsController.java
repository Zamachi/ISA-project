package com.example.news_rest.controller;

import com.example.news_rest.entity.Author;
import com.example.news_rest.entity.News;
import com.example.news_rest.model.AuthorModel;
import com.example.news_rest.model.NewsModel;
import com.example.news_rest.service.AuthorService;
import com.example.news_rest.service.NewsService;
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
