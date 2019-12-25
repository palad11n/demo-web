package com.example.demoweb.com.example.demoweb.controller;

import com.example.demoweb.com.example.demoweb.controller.PostsViewController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value = {"/create-post-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-post-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class ControllerDBTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PostsViewController mainController;
    @Test
    public void controllerTest() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())//выводить выполнение теста в консоль
                .andExpect(status().isOk())//обертка assertThat
                .andExpect(content().string(containsString("testiiing")));
        this.mockMvc.perform(get("/"))
                .andDo(print())//выводить выполнение теста в консоль
                .andExpect(status().isOk())//обертка assertThat
                .andExpect(content().string(containsString("good night")));
        this.mockMvc.perform(get("/"))
                .andDo(print())//выводить выполнение теста в консоль
                .andExpect(status().isOk())//обертка assertThat
                .andExpect(content().string(containsString("good morning")));
    }

}
