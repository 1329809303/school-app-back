package com.example.demo.domain;

import javax.persistence.Entity;

@Entity
public class Article {
    private String id;
    private int UserImage;
    private  String title;
    private  String content;
    private  String username;
    private  String time;
    private  int picture;
    private int background;
   public Article(String username, String title, String time, String content, int UserImage, int picture, int background){
        this.content=content;
        this.picture=picture;
        this.time=time;
        this.title=title;
        this.UserImage=UserImage;
        this.username=username;
        this.background=background;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserImage(int fruitImage) {
        this.UserImage = fruitImage;
    }

    public int getUserImage() {
        return UserImage;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public int getPicture() {
        return picture;
    }
}

