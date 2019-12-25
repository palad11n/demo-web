package com.example.demoweb.service;

import com.example.demoweb.com.example.demoweb.controller.PostsCreateController;
import com.example.demoweb.model.Post;
import com.example.demoweb.repository.PostRepository;
import javafx.geometry.Pos;
import org.hamcrest.internal.ArrayIterator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/application-test.properties")
public class PostServiceTest {
    @Autowired
    private PostService postService;

    @MockBean
    private PostRepository postRepository;

    @Test
    public void listAllPosts() {
        postService.create(ArgumentMatchers.anyString());
        Assert.assertNotNull(postService.listAllPosts());
        int sizeAct = Arrays.asList(postService.listAllPosts()).size();
        int sizeExp = 1;
        boolean isRemove = postService.removeAll();
        Assert.assertEquals(sizeExp, sizeAct);
        Assert.assertTrue(isRemove);
    }

    @Test
    public void createAndRemoveAll() {
        Post post = new Post(20l, "sooome thing", new Date());
        Assert.assertTrue(postService.create(post));
        Mockito.verify(postRepository, Mockito.times(1)).save(post);
    }

    @Test
    public void removeAll() {
        Assert.assertTrue(postService.removeAll());
        Mockito.verify(postRepository, Mockito.times(1)).deleteAll();
    }

    @Test
    public void createFail() {
        Post post = new Post();
        post.setId(1l);

        Mockito.doReturn(new Post())
                .when(postRepository)
                .findPostById(1l);
        boolean isCreated = postService.create(post);
        Assert.assertFalse(isCreated);

    }
}