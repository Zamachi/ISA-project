package com.example.news_rest.service;

import com.example.news_rest.entity.Author;
import com.example.news_rest.entity.NewsLocalizations;
import com.example.news_rest.entity.Tags;
import com.example.news_rest.model.AuthorModel;
import com.example.news_rest.model.NewsLocalizationsModel;
import com.example.news_rest.model.TagsModel;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class AutoMapperService implements IAutoMapperService {
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public <T> T map(Object model, Class<T> entity){
        Converter<String, String> toUppercase =
                ctx -> ctx.getSource() == null ? null : ctx.getSource().toUpperCase(Locale.ROOT);
        modelMapper.createTypeMap(TagsModel.class, Tags.class);
       modelMapper.createTypeMap(AuthorModel.class, Author.class).addMapping(AuthorModel::getFirstName, Author::setLastName).include(Author.class);
//        modelMapper.createTypeMap(AuthorModel.class, Author.class).addMappings(
//                mapper -> mapper.using(toUppercase).map(AuthorModel::getFirstName, Author::setLastName));
//        modelMapper.addMappings(new PropertyMap<Author, AuthorModel>() {
//            @Override
//            protected void configure() {
//               skip(source.getFirstName());
//            }
//        });
        modelMapper.createTypeMap(NewsLocalizationsModel.class, NewsLocalizations.class);
        modelMapper.createTypeMap(Tags.class, TagsModel.class);
        modelMapper.createTypeMap(Author.class, AuthorModel.class);
        modelMapper.createTypeMap(NewsLocalizations.class, NewsLocalizationsModel.class);

        return modelMapper.map(model, entity);
    }

    @Override
    public Author mapToAuthorEntity(AuthorModel model)
    {
        return modelMapper.map(model, Author.class);
    }

    @Override
    public AuthorModel mapToAuthorModel(Author entity)
    {
        return modelMapper.map(entity, AuthorModel.class);
    }
}
