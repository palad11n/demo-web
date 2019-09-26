package com.example.demoweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Post implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String text;
    private Integer likes;
    private Date creationDate;


    public Post() {
    }

    public Post(Long id, String text, Date creationDate) {
        this.id = id;
        this.text = text;
        this.likes = 0;
        this.creationDate = creationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Long getId() {
        return id;
    }

    public Integer getLikes() {
        return likes;
    }
}
