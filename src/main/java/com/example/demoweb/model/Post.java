package com.example.demoweb.model;

public class Post {
    private String text;
    private Integer likes;

    public Post(String text,Integer likes){
        this.text=text;
        this.likes=likes;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Integer getLikes() {
        return likes;
    }
}
