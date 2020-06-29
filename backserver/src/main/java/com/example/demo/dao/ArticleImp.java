package com.example.demo.dao;

import com.example.demo.domain.Article;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import java.util.List;

@Component      //标记Article为一个bean，后面可以用@Autowired直接创建对象
public class ArticleImp implements ArticleDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    public void saveArticle(Article article) {
        System.out.println(mongoTemplate.toString());
        mongoTemplate.save(article);
    }
    public void removeArticle(long id) {
        Query query = new Query(Criteria.where("id").is(id));//查找其id字段的值与传入参数id相等的数据
        mongoTemplate.remove(query,Article.class);
    }

    public List<Article> findArticleByName(String username) {
        Query query = new Query(Criteria.where("username").is(username));
        List<Article> article = mongoTemplate.find(query,Article.class);
        return article;
    }
    public Article Articlebyid(long id) {
        Query query = new Query(Criteria.where("id").is(id));
        Article article = mongoTemplate.findOne(query,Article.class);
        return article;
    }
    public List<Article> findArticleByTitle(String title){
        Query query = new Query(Criteria.where("title").regex(title));
        List<Article> article = mongoTemplate.find(query,Article.class);
        return article;
    }
    public int updateArticle(Article article) {
        Query query = new Query(Criteria.where("userName").is(article.getUsername()));
        Update update = new Update().set("title",article.getTitle()).set("content",article.getContent()).set("picture",article.getPicture());
        //更新查询返回的结果集的第一条数据
        UpdateResult result = mongoTemplate.updateFirst(query,update,Article.class);
        //更新查询到的所有结果集
        //UpdateResult all_result = mongoTemplate.updateMulti(query,update,User.class);
        if(result!= null)
            return (int) result.getModifiedCount();
        else
            return 0;
    }
}
