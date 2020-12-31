package com.christianhoerauf.fizzbuzzserver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzConverterTest {
    private FizzBuzzConverter instanceUnderTest;

    @BeforeEach
    void setUp(){
        this.instanceUnderTest = new FizzBuzzConverter();
    }

    @Test
    void converterShouldReturnNumberToStringOfNumber() {
        assertEquals("1", this.instanceUnderTest.convert(1));
    }

    @Test
    void converterShouldReturnFizzForThree() {
        assertEquals("fizz", this.instanceUnderTest.convert(3));
    }
    @Test
    void converterShouldReturnBuzzForFive() {
        assertEquals("buzz", this.instanceUnderTest.convert(5));
    }
    @Test
    void converterShouldReturnFizzBuzzForFifteen() {
        assertEquals("fizzbuzz", this.instanceUnderTest.convert(15));
    }
}
