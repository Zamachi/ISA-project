package com.example.trade_centre.controller;

import com.example.trade_centre.entity.Author;
import com.example.trade_centre.model.AuthorModel;
import com.example.trade_centre.service.AuthorService;
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
