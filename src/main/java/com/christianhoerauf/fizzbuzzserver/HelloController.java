package com.christianhoerauf.fizzbuzzserver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}


/**
 * ToDo:
 * implement FizzBuzzResponse
 * implement FizzBuzzController that returns
 * {
 *     input: integer
 *     numList: String []
 * }
 * Use google-gson to transform it to json
 * Start Test with
 * {
 *     input: 0
 *     numList: []
 * }
 *
 * implement FizzBuzzFactory
 */

