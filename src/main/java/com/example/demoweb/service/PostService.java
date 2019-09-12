package com.example.demoweb.service;

import com.example.demoweb.model.Post;

import java.util.ArrayList;
import java.util.Date;

@org.springframework.stereotype.Service
public class PostService {
    public ArrayList<Post> listAllPosts() {
        ArrayList<Post> posts = new ArrayList<Post>();
        for (int i = 1; i < 5; i++) {
            posts.add(new Post("test" + i,new Date()));
        }
        return posts;
    }
}
