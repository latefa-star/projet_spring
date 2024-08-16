package com.example.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String getHome()
    {
        return "Hello World";
    }
    @GetMapping("/{name}")
    public String getName(@PathVariable String name)
    {
        return String.format("Hello %s in ur section",name);
    }
}
