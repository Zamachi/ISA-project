package com.example.news_rest.service;

import com.example.news_rest.entity.Author;
import com.example.news_rest.entity.Tags;
import com.example.news_rest.model.AuthorModel;
import com.example.news_rest.repository.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Service
public class AuthorService implements IAuthorService, UserDetailsService {
    @Autowired
    private IAuthorRepository authorRepository;
    @Autowired
    private AutoMapperService autoMapperService;

    @Override
    public Author insert(AuthorModel model) {
        model.setSlug((model.getFirstName() + " " + model.getLastName()).toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9-]", "-"));

        var sameSlugs = findAllBySlug(model.getSlug());

        if (sameSlugs.size() > 0) {
            model.setSlug(model.getSlug() + "-" + sameSlugs.size());
        }

        model.setUsername(model.getSlug());

        var test = autoMapperService.map(model, Author.class);
        return authorRepository.insert(test);
    }

    @Override
    public Author insert(Author entity) {
        return authorRepository.insert(entity);
    }

    @Override
    public Author findOneBySlug(String slug) {
        return  authorRepository.findBySlug(slug);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public List<Author> findAllBySlug(String slug) {
        return authorRepository.findAllBySlug(slug);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Author author = authorRepository.findByUsername(s);


        if (author == null){
            throw new UsernameNotFoundException("Author not found!");
        }

        List authorities = Arrays.asList(new SimpleGrantedAuthority("user"));

        return new User(author.getUsername(), author.getPassword(), authorities);
    }
}
