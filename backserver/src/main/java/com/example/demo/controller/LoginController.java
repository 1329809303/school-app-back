package com.example.demo.controller;

import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import com.example.demo.domain.SignUp;
@RestController
@RequestMapping("/rest")
public class LoginController {
    @Autowired
    private MongoTemplate mongoTemplate;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Boolean Login(@RequestBody User user) {
        Query query = new Query(Criteria.where("userName").is(user.getUserName()));
        if(query==null)
            return false;
        else {
            SignUp signUp = mongoTemplate.findOne(query, SignUp.class);
            if (signUp.getPassword().length() == user.getPassword().length()) {
                return true;
            } else {
                return false;
            }
        }

    }

}
