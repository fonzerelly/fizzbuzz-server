package com.christianhoerauf.fizzbuzzserver;

import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;


@RestController
public class FizzBuzzController {
    private final FizzBuzzConverter converter;

    public FizzBuzzController(FizzBuzzConverter converter){
        this.converter = converter;
    }
    @GetMapping("/fizzbuzz")
    public String index(@RequestParam int maxNum) {
        int lastIndex = maxNum + 1;
        String[] result = new String[maxNum];
        for(int i=1; i <= maxNum; i++) {
            result[i-1] = converter.convert(i);
        }
        FizzBuzzResponse response = new FizzBuzzResponse(maxNum, result/*new String[]{converter.convert(1), converter.convert(2), converter.convert(3)}*/);
        Gson gson = new Gson();
        return gson.toJson(response);
    }
}
