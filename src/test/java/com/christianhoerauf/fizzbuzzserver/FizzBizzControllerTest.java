package com.christianhoerauf.fizzbuzzserver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class FizzBizzControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldProvideFeedbackAboutRequestedSize() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/fizzbuzz?num=0").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.maxNum", equalTo(0)));
    }
}
