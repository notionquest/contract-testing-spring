package com.contract.producer.testing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @GetMapping
    @RequestMapping("/add")
    public Long add(@RequestParam("a") Long a, @RequestParam("b") Long b) {
        return a + b;
    }
}
