package com.christianhoerauf.fizzbuzzserver;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzConverter {
    private final FizzBuzzNumberConverter fizzer;
    private final FizzBuzzNumberConverter buzzer;

    public FizzBuzzConverter() {
        FizzBuzzNumberConverterFactory factory = new FizzBuzzNumberConverterFactory();
        fizzer = factory.create(3,"fizz");
        buzzer = factory.create(5, "buzz");
    }

    public String convert(int i) {
        String result = this.fizzer.convert(i) + this.buzzer.convert(i);

        if (!result.equals("")) {
            return result;
        }
        return String.valueOf(i);
    }
}
