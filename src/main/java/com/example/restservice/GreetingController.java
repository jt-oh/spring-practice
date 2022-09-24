package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";
    private static AtomicLong counter = new AtomicLong();

    @GetMapping("greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);

        return "greeting";
    }

    @GetMapping("api/v1/greeting")
    @ResponseBody
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
    }
}