package com.example.demoweb.service;

import com.example.demoweb.model.Post;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

@Service
public class LikesService {
    @Autowired
    PostService postsService;

    public Integer like(Long postId) {
        Post post = postsService.listAllPosts().get(postId.intValue());
        post.setLikes(post.getLikes() + 1);
        return post.getLikes();
    }
}
