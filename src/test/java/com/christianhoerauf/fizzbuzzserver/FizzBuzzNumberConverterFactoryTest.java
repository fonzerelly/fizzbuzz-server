package com.christianhoerauf.fizzbuzzserver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FizzBuzzNumberConverterFactoryTest {
    private FizzBuzzNumberConverter fizzer;
    private FizzBuzzNumberConverter buzzer;

    @BeforeEach
    public void setUp() {
        FizzBuzzNumberConverterFactory instance = new FizzBuzzNumberConverterFactory();
        this.fizzer = instance.create(3, "fizz");
        this.buzzer = instance.create( 5, "buzz");
    }
    @Test
    public void shouldCreateAFizzBuzzConverterFor3ToFizz() {
        assertEquals("", this.fizzer.convert(1));
    }

    @Test void converterShouldReturnFizzOn3() {
        assertEquals("fizz", this.fizzer.convert(3));
    }
    @Test void converterShouldReturnFizzOnMultiplesOf3() {
        assertEquals("fizz", this.fizzer.convert(6));
    }

    @Test void converterShouldReturnBuzzOnMultiplesOf5() {
        assertEquals("buzz", this.buzzer.convert(5));
    }
}
