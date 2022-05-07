package com.github.hetikk.learn;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.hetikk.learn.model.Author;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
@AutoConfigureMockMvc
@ExtendWith(PostgreSQLExtension.class)
@DirtiesContext
public class AuthorTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private static Long authorID1;
    private static Long authorID2;

    @Test
    public void _1_createAuthor() throws Exception {
        Author author1 = new Author();
        author1.name = "Test name 1";
        String body = objectMapper.writeValueAsString(author1);
        String response = mockMvc.perform(post("/authors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(notNullValue(Long.class))))
                .andExpect(jsonPath("$.name", is(author1.name)))
                .andReturn().getResponse().getContentAsString();
        authorID1 = JsonPath.parse(response).read("$.id", Long.class);

        Author author2 = new Author();
        author2.name = "Test name 1";
        body = objectMapper.writeValueAsString(author2);
        response = mockMvc.perform(post("/authors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(notNullValue(Long.class))))
                .andExpect(jsonPath("$.name", is(author2.name)))
                .andReturn().getResponse().getContentAsString();

        authorID2 = JsonPath.parse(response).read("$.id", Long.class);
    }

    @Test
    public void _2_getOne() throws Exception {
        mockMvc.perform(get("/authors/" + authorID1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", not(empty())))
                .andExpect(jsonPath("$.id", is(authorID1.intValue())));

        mockMvc.perform(get("/authors/" + authorID2))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", not(empty())))
                .andExpect(jsonPath("$.id", is(authorID2.intValue())));
    }

    @Test
    public void _3_getAll() throws Exception {
        mockMvc.perform(get("/authors"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", not(empty())))
                .andExpect(jsonPath("$.length()", is(2)))
                .andExpect(jsonPath("$[0].id", is(authorID1.intValue())))
                .andExpect(jsonPath("$[1].id", is(authorID2.intValue())));
    }

    @Test
    public void _4_update() throws Exception {
        Author author = new Author();
        author.name = "Updated test name";
        String body = objectMapper.writeValueAsString(author);

        mockMvc.perform(put("/authors/" + authorID1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", not(empty())))
                .andExpect(jsonPath("$.id", is(authorID1.intValue())))
                .andExpect(jsonPath("$.name", is(author.name)));
    }

    @Test
    public void _5_delete() throws Exception {
        mockMvc.perform(delete("/authors/" + authorID1))
                .andExpect(status().isNoContent());

        mockMvc.perform(delete("/authors/" + authorID2))
                .andExpect(status().isNoContent());
    }

}

