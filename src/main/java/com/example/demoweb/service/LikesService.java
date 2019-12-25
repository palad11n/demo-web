package com.example.demoweb.service;

import com.example.demoweb.repository.PostRepository;
import com.example.demoweb.model.Post;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

@Service
public class LikesService {
    @Autowired
    PostRepository postRepository;

    public Integer like(Long postId) {
        Post post = postRepository.findPostById(postId);
        if (post == null)
            return -1;
        post.setLikes(post.getLikes() + 1);
        postRepository.save(post);
        return post.getLikes();
    }
}
