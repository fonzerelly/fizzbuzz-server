package com.christianhoerauf.fizzbuzzserver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;

@RestController
public class FizzBuzzController {
    @RequestMapping("/fizzbuzz")
    public String index() {
        FizzBuzzResponse response = new FizzBuzzResponse(0);
        Gson gson = new Gson();
        return gson.toJson(response);
    }
}
