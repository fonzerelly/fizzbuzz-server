package com.christianhoerauf.fizzbuzzserver;

import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;

@RestController
public class FizzBuzzController {
    @GetMapping("/fizzbuzz")
    public String index(@RequestParam int maxNum) {
        FizzBuzzResponse response = new FizzBuzzResponse(maxNum, new String[]{"1", "2", "fizz"});
        Gson gson = new Gson();
        return gson.toJson(response);
    }
}
