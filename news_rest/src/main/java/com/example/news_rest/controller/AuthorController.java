package com.example.news_rest.controller;

import com.example.news_rest.entity.Author;
import com.example.news_rest.model.AuthorModel;
import com.example.news_rest.service.AuthorService;
import com.example.news_rest.service.AutoMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("insert")
    public Author insert(@RequestBody AuthorModel model)
    {
        return authorService.insert(model);
    }

    @GetMapping("findonebyslug")
    public Author findOneBySlug (String slug)
    {
        return authorService.findOneBySlug(slug);
    }

    @PostMapping("createaccount")
    public Author createAccount(@RequestBody AuthorModel model)
    {
        model.setPassword(passwordEncoder.encode(model.getPassword()));

        return authorService.insert(model);
    }
}
