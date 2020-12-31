package com.christianhoerauf.fizzbuzzserver;

public class FizzBuzzNumberConverterFactory {
    public FizzBuzzNumberConverter create(int number, String replaceable) {
        return value -> value % number == 0 ? replaceable  : "";
    }
}
