package com.example.beadando;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {

    @GetMapping(value = "/Hello/World")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(value = "/Hello/World/{param}")
    public String helloWorldWithPathVariable(@PathVariable String param) {
        return "Hello World " + param;
    }

    @GetMapping(value = "/Hello/World/{param}/{param2}")
    public String helloWorldWithPathVariable2(@PathVariable String param, @PathVariable String param2) {
        return "Hello World " + param + " " + param2;
    }

    @GetMapping(value = "/Hello/World/request")
    public String helloWorldWithRequestParam(@RequestParam String param) {
        return "Hello World " + param;
    }

}
