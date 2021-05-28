package com.example.news_rest;

import com.example.news_rest.entity.Author;
import com.example.news_rest.entity.NewsLocalizations;
import com.example.news_rest.entity.Tags;
import com.example.news_rest.model.AuthorModel;
import com.example.news_rest.model.NewsLocalizationsModel;
import com.example.news_rest.model.TagsModel;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NewsRestApplication {
    @Bean
    public ModelMapper modelMapper() {
        return  new ModelMapper();
    }
    public static void main(String[] args) {
        SpringApplication.run(NewsRestApplication.class, args);
    }

}
