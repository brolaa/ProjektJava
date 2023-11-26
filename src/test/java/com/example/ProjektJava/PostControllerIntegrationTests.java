package com.example.ProjektJava;

import com.example.ProjektJava.model.Post;
import com.example.ProjektJava.payload.request.PostRequest;
import com.example.ProjektJava.repository.PostRepository;
import com.example.ProjektJava.security.WebSecurityConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = ProjektJavaApplication.class)
@AutoConfigureMockMvc
@Import(WebSecurityConfig.class)
@AutoConfigureTestDatabase
public class PostControllerIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostRepository postRepository;

    @Test
    public void whenValidInput_thenCreatePost() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        PostRequest post = new PostRequest("Test", "Post testowy", "To jest post testowy", "Poland", "2023-11-10", "2023-11-20");

        String jsonRequest = objectMapper.writeValueAsString(post);

        mockMvc.perform(post("/api/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Test"))
                .andExpect(jsonPath("$.description").value("Post testowy"))
                .andExpect(jsonPath("$.content").value("To jest post testowy"))
                .andExpect(jsonPath("$.country").value("Poland"))
                .andExpect(jsonPath("$.departDate").value("2023-11-10"))
                .andExpect(jsonPath("$.returnDate").value("2023-11-20"));

        assertThat(postRepository.findAll()).hasSize(1);

        postRepository.deleteAll();
    }

    @Test
    public void givenPosts_whenGetPost_thenStatus200() throws Exception {
        createTestPost(new Post("Jeden", "Pierwszy post", "Pierwszy post testowy", "Poland",
                LocalDate.parse("2023-11-10"), LocalDate.parse("2023-11-20")));
        createTestPost(new Post("Dwa", "Drugi post", "Drugi post testowy", "Germany",
                LocalDate.parse("2023-10-10"), LocalDate.parse("2023-10-20")));

        mockMvc.perform(get("/api/posts"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].title").value("Jeden"))
                .andExpect(jsonPath("$[0].description").value("Pierwszy post"))
                .andExpect(jsonPath("$[0].content").value("Pierwszy post testowy"))
                .andExpect(jsonPath("$[0].country").value("Poland"))
                .andExpect(jsonPath("$[0].departDate").value("2023-11-10"))
                .andExpect(jsonPath("$[0].returnDate").value("2023-11-20"))
                .andExpect(jsonPath("$[1].title").value("Dwa"))
                .andExpect(jsonPath("$[1].description").value("Drugi post"))
                .andExpect(jsonPath("$[1].content").value("Drugi post testowy"))
                .andExpect(jsonPath("$[1].country").value("Germany"))
                .andExpect(jsonPath("$[1].departDate").value("2023-10-10"))
                .andExpect(jsonPath("$[1].returnDate").value("2023-10-20"));
    }

    private void createTestPost(Post post) {
        postRepository.saveAndFlush(post);
    }
}
