package com.example.restservice;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest
public class GreetingControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GreetingController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void shouldResponseDefaultMessageToGetView() throws Exception {
        mockMvc.perform(get("/greeting"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.TEXT_HTML + ";charset=UTF-8"))
            .andExpect(content().string(containsString("Hello, World")));
    }

    @Test
    public void shouldResponseQueriedMessageToGetView() throws Exception {
        String[] names = {"Tom", "Michale", "Ben", "Jerry", "Kelly", "Christine"};

        for (String name : names)
            mockMvc.perform(get("/greeting?name=" + name))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML + ";charset=UTF-8"))
                .andExpect(content().string(containsString("Hello, " + name)));
    }

    @Test
    public void shouldResponseDefaultMessageToGetApi() throws Exception {
        mockMvc.perform(get("/api/v1/greeting"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().string(containsString("Hello, World")));
    }

    @Test
    public void shouldResponseQueriedMessageToGetApi() throws Exception {
        String[] names = {"Tom", "Michale", "Ben", "Jerry", "Kelly", "Christine"};

        for (String name : names)
            mockMvc.perform(get("/api/v1/greeting?name=" + name))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString("Hello, " + name)));
    }
}
