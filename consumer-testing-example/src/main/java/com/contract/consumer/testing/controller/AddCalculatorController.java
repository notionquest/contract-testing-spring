package com.contract.consumer.testing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.net.URI;

@RestController
public class AddCalculatorController {

    private String CONSUMER_BASE_URL = "http://localhost:8090";

    @GetMapping
    @RequestMapping("/add")
    public String add(@RequestParam("a") Long a, @RequestParam("b") Long b) {
        DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(CONSUMER_BASE_URL);
        URI uri = uriBuilderFactory.uriString("/calculator/add")
                .queryParam("a", "{a}")
                .queryParam("b", "{b}")
                .build(a, b);
        return WebClient.create("http://localhost:8090")
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
