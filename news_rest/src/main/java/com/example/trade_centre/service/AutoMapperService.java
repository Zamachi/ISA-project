package com.example.trade_centre.service;

import com.example.trade_centre.entity.Author;
import com.example.trade_centre.entity.Tags;
import com.example.trade_centre.entity.User;
import com.example.trade_centre.model.AuthorModel;
import com.example.trade_centre.model.TagsModel;
import com.example.trade_centre.model.UserModel;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
        modelMapper.createTypeMap(Tags.class, TagsModel.class);
        modelMapper.createTypeMap(Author.class, AuthorModel.class);

        modelMapper.createTypeMap(UserModel.class, User.class);
        modelMapper.createTypeMap(User.class, UserModel.class);

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
