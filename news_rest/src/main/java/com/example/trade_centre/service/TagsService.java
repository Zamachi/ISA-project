package com.example.trade_centre.service;

import com.example.trade_centre.model.AuthorModel;
import com.example.trade_centre.model.NewsModel;
import com.example.trade_centre.model.TagsModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class TagsService implements ITagsService{

    @Override
    public List<TagsModel> generateAuthorTags(AuthorModel model)
    {
        List<TagsModel> listOfTags = new ArrayList<TagsModel>();

        TagsModel tag = new TagsModel();
        tag.setName(model.getFirstName() + " " + model.getLastName());
        tag.setName_search((model.getFirstName() + " " + model.getLastName()).toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9-]", "-"));

        listOfTags.add(tag);

        tag.setName(model.getCity());
        tag.setName_search((model.getCity()).toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9-]", "-"));
        listOfTags.add(tag);

        tag.setName(model.getCountry());
        tag.setName_search((model.getCountry()).toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9-]", "-"));
        listOfTags.add(tag);

        return listOfTags;
    }

    @Override
    public List<TagsModel> generateNewsTags(NewsModel model)
    {
        List<TagsModel> listOfTags = new ArrayList<TagsModel>();

        TagsModel tag = new TagsModel();

        tag.setName(model.getAuthor().getFirstName() + " " + model.getAuthor().getLastName());
        tag.setName_search((model.getAuthor().getFirstName() + " " + model.getAuthor().getLastName()).toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9-]", "-"));
        listOfTags.add(tag);

        TagsModel tag2 = new TagsModel();

        tag2.setName(model.getNewsLocalizations().getTitle());
        tag2.setName_search((model.getNewsLocalizations().getTitle()).toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9-]", "-"));
        listOfTags.add(tag2);
        TagsModel tag3 = new TagsModel();
        tag3.setName(model.getNewsLocalizations().getCulture());
        tag3.setName_search((model.getNewsLocalizations().getCulture()).toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9-]", "-"));
        listOfTags.add(tag3);

        return listOfTags;
    }
}
