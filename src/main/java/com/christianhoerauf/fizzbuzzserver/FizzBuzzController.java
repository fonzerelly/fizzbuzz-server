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
        FizzBuzzResponse response = new FizzBuzzResponse(maxNum, new String[]{"1", "2", this.converter.convert(3)});
        Gson gson = new Gson();
        return gson.toJson(response);
    }
}
