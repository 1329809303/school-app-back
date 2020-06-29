package com.example.demo.dao;
import com.example.demo.domain.Article;

import java.util.List;

public interface ArticleDao {
    public void saveArticle(Article article);//新增数据
    public void removeArticle(long id);    //删除数据
    public List<Article> findArticleByName(String username);    //通过名字查找数据
    public Article Articlebyid(long id);
    public List<Article> findArticleByTitle(String title);
    public int updateArticle(Article article);           //修改数据*/
}
