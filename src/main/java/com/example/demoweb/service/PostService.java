package com.example.demoweb.service;

import com.example.demoweb.model.Post;
import com.example.demoweb.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.Date;

@org.springframework.stereotype.Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public Iterable<Post> listAllPosts() {
        return postRepository.findAll();
    }

    public void create(String text) {
        Long id=postRepository.count();
        Post post = new Post(id==0?id:id+1, text, new Date());
        postRepository.save(post);
    }
}
