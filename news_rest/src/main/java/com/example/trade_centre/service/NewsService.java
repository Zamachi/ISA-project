package com.example.trade_centre.service;

import com.example.trade_centre.entity.News;
import com.example.trade_centre.model.NewsModel;
import com.example.trade_centre.repository.INewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class NewsService implements INewsService{
    @Autowired
    private INewsRepository newsRepository;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private TagsService tagsService;
    @Autowired
    private AutoMapperService autoMapperService;
    @Autowired
    private NewsLocalizationsService newsLocalizationsService;

    @Override
    public News insertNews(NewsModel model)
    {
        model.setTags(tagsService.generateNewsTags(model));

        model.setSlug((model.getNewsLocalizations().getTitle()).toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9-]", "-"));

        var sameSlugs = findAllBySlug(model.getSlug());

        if (sameSlugs.size() > 0) {
            model.setSlug(model.getSlug() + "-" + sameSlugs.size());
        }

        model.getNewsLocalizations().setNewsSlug(model.getSlug());

        var news = autoMapperService.map(model, News.class);

        if (model.getAuthor().getSlug() == null)
        {
            var author = authorService.insert(model.getAuthor());
            news.setAuthor(author);
        }else{
            var author = authorService.findOneBySlug(model.getAuthor().getSlug());
            news.setAuthor(author);
        }

        newsLocalizationsService.insert(news.getNewsLocalizations());

        news.setNewsLocalizations(null);

        return newsRepository.insert(news);
    }

    @Override
    public News insert(NewsModel model) {
        return null;
    }

    @Override
    public News findOneBySlug(String slug) {
        return newsRepository.findBySlug(slug);
    }
    @Override
    public List<News> findAll() {
        return newsRepository.findAll();
    }
    @Override
    public List<News> findAllBySlug(String slug) {
        return newsRepository.findAllBySlug(slug);
    }
}
