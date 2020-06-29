package com.example.demo.dao;

import com.example.demo.domain.User;
import com.example.demo.domain.Article;

public interface UserDao {

    public void saveArticle(Article article);//新增数据
   public void removeUser(Long id);    //删除数据
     public void saveUser(User user);
    public User findUserByName(String name);    //通过名字查找数据
    public Article Articlebytitle(String title);
    public int updateUser(User user);           //修改数据*/
}
