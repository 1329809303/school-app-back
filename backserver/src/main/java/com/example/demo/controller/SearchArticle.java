package com.example.demo.controller;
import com.example.demo.domain.Article;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/rest")

public class SearchArticle {
    @Autowired
    private MongoTemplate mongoTemplate;
    @RequestMapping(value = "/GetArticle", method = RequestMethod.POST)
    public List<Article> GetArticle(@RequestParam String username)
    {
        Query query = new Query(Criteria.where("username").regex(username,"i"));
        List<Article> articles = mongoTemplate.find(query,Article.class);
        if(articles==null){
            return null;
        }
        else {

            return articles;
        }
    };
}
