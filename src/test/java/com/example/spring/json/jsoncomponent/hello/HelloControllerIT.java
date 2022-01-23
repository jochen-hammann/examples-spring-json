package com.example.spring.json.jsoncomponent.hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.spring.json.jsoncomponent.dto.MyDto;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerIT
{
    // ============================== [Fields] ==============================

    // -------------------- [Private Fields] --------------------

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    // ============================== [Unit Tests] ==============================

    // -------------------- [Test Helper Classes] --------------------

    // -------------------- [Test Helper Methods] --------------------

    // -------------------- [Test Initialization] --------------------

    // -------------------- [Tests] --------------------

    @Test
    void getTest() throws Exception
    {
        String result = mvc.perform(get("/hello")).andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }

    @Test
    void postTest() throws Exception
    {
        String name = "Test Name";
        Instant instant = Instant.now();

        MyDto myDto = new MyDto();
        myDto.setName(name);
        myDto.setInstant(instant);

        String body = this.objectMapper.writeValueAsString(myDto);

        mvc.perform(post("/hello").contentType(MediaType.APPLICATION_JSON).content(body)).andExpect(jsonPath("$.name").value(name));

    }
}
