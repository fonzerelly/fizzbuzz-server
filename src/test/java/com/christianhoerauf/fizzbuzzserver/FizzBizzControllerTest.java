package com.christianhoerauf.fizzbuzzserver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Import(FizzBuzzConverterTestConfiguration.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FizzBizzControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private FizzBuzzConverter converter;

    @BeforeEach
    public void setUp() {
        Mockito.reset(converter);
    }

    @Test
    public void shouldProvideFeedbackAboutRequestedSizeZero() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/fizzbuzz?maxNum=0").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.maxNum", equalTo(0)));
    }

    @Test
    public void shouldProvideFeedbackAboutRequestedSizeOne() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/fizzbuzz?maxNum=1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.maxNum", equalTo(1)));
    }

    @Test
    public void shouldProvideArrayOfResultingNumbersUpToThree() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/fizzbuzz?maxNum=3").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.numbers", hasItem("1")))
                .andExpect(jsonPath("$.numbers", hasItem("2")))
                .andExpect(jsonPath("$.numbers", hasItem("fizz")));
    }

    @Test
    public void shouldProvideArrayOfResultingNumbersUpToFive() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/fizzbuzz?maxNum=5").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.numbers", hasItem("4")))
                .andExpect(jsonPath("$.numbers", hasItem("buzz")));

    }

    @Test
    public void shouldAccessFizzBuzzConverterToFillNumbers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/fizzbuzz?maxNum=3").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        Mockito.verify(converter, times(3)).convert(anyInt());
    }

}
