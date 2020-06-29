package com.example.demo.controller;
import com.example.demo.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class ArticleController {
    @Autowired
    private MongoTemplate mongoTemplate;
    @RequestMapping(value = "/postArticle", method = RequestMethod.POST)
    public Boolean PostArticle(@RequestBody Article article)
    {
        mongoTemplate.save(article);
        return Boolean.TRUE;
    };
}
