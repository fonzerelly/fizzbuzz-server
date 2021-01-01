package com.christianhoerauf.fizzbuzzserver;

import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@TestConfiguration
public class FizzBuzzConverterTestConfiguration {
    @Bean
    @Primary
    public FizzBuzzConverter converter() {
        return Mockito.spy(FizzBuzzConverter.class);
    }
}
