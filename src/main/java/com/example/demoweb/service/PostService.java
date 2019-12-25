package com.example.demoweb.service;

import com.example.demoweb.model.Post;
import com.example.demoweb.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public Iterable<Post> listAllPosts() {
        return postRepository.findAll();
    }

    public boolean create(String text) {
        try {
            Long id = postRepository.count();
            Post post = new Post(id == 0 ? id : id + 1, text, new Date());
            postRepository.save(post);
            return true;
        } catch (Exception e) {
            //ignore
        }
        return false;
    }

    public boolean create(Post post) {
        Post postFromDb = postRepository.findPostById(post.getId());
        if (postFromDb != null)
            return false;
        postRepository.save(post);
        return true;
    }

    public boolean removeAll() {
        try {
            postRepository.deleteAll();
            return true;
        } catch (Exception e) {
            //ignore
        }
        return false;
    }
}
