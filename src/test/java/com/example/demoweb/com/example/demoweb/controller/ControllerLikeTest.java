package com.example.demoweb.com.example.demoweb.controller;

import com.example.demoweb.com.example.demoweb.controller.LikesController;
import com.example.demoweb.com.example.demoweb.controller.PostsViewController;
import com.example.demoweb.service.LikesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(LikesController.class)
@TestPropertySource("/application-test.properties")
public class ControllerLikeTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LikesService likesService;

    @Test
    public void likePostFirst() throws Exception {
        when(likesService.like(1l)).thenReturn(11);

        when(likesService.like(1l)).thenReturn(12);
        this.mockMvc.perform(post("/post/1/like"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("12")));
    }

    @Test
    public void likePostTwo() throws Exception {
        when(likesService.like(2l)).thenReturn(1);
        this.mockMvc.perform(post("/post/2/like"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("1")));
        when(likesService.like(2l)).thenReturn(2);
        this.mockMvc.perform(post("/post/2/like"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("2")));
    }

    @Test
    public void likePostThree() throws Exception {
        when(likesService.like(3l)).thenReturn(3);
        when(likesService.like(3l)).thenReturn(4);
        this.mockMvc.perform(post("/post/3/like"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("4")));
    }
}
