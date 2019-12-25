package com.example.demoweb.service;

import com.example.demoweb.model.Post;
import com.example.demoweb.repository.PostRepository;
import javafx.geometry.Pos;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/application-test.properties")
public class LikesServiceTest {
    @Autowired
    private LikesService likesService;

    @MockBean
    private PostRepository postRepository;

    @MockBean
    private Post post;

    @Test
    public void like() {
        post.setId(10l);
        Mockito.doReturn(post)
                .when(postRepository)
                .findPostById(10l);
        int likes = likesService.like(10l);
        Mockito.verify(post, Mockito.times(1)).setLikes(ArgumentMatchers.anyInt());
        Assert.assertNotEquals(-1, likes);
    }
}