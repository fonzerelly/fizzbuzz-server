package com.christianhoerauf.fizzbuzzserver;

import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;

import java.util.stream.IntStream;


@RestController
public class FizzBuzzController {
    private final FizzBuzzConverter converter;

    public FizzBuzzController(FizzBuzzConverter converter){
        this.converter = converter;
    }
    @GetMapping("/fizzbuzz")
    public String index(@RequestParam int maxNum) {
        String[] result = IntStream.rangeClosed(1, maxNum)
                .mapToObj(num -> this.converter.convert(num))
                .toArray(String[]::new);
        FizzBuzzResponse response = new FizzBuzzResponse(maxNum, result);
        Gson gson = new Gson();
        return gson.toJson(response);
    }
}
