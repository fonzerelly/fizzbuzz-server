package com.christianhoerauf.fizzbuzzserver;

public class FizzBuzzResponse {
    private final int maxNum;
    private final String[] numbers;

    public FizzBuzzResponse(int maxNum, String[] numbers) {
        this.maxNum = maxNum;
        this.numbers = numbers;
    }
}
