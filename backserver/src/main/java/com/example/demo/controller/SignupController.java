package com.example.demo.controller;

import com.example.demo.domain.SignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.mongodb.core.MongoTemplate;


@RestController
@RequestMapping("/rest")
public class SignupController {
    @Autowired
    private MongoTemplate mongoTemplate;
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public Boolean Login(@RequestBody SignUp Signupuser) {
        mongoTemplate.save(Signupuser);
        return Boolean.TRUE;
    }

}
