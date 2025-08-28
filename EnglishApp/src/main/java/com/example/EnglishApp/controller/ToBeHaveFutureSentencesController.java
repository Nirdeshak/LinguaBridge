
package com.example.EnglishApp.controller;

import org.springframework.web.bind.annotation.*;

import com.example.EnglishApp.Service.ToBeHaveFutureSentencesService;
import com.example.EnglishApp.entity.ToBeHaveFutureSentences;

import java.util.List;

@RestController
@RequestMapping("/api/tobe/have/future")
@CrossOrigin(origins = "http://localhost:5174")  // 👈 allow frontend

public class ToBeHaveFutureSentencesController {

    private final ToBeHaveFutureSentencesService service;

    public ToBeHaveFutureSentencesController(ToBeHaveFutureSentencesService service) {
        this.service = service;
    }

    // Get all sentences
    @GetMapping("/all")
    public List<ToBeHaveFutureSentences> GetAllToBeHaveFuture() {
        return service.GetAllToBeHaveFuture();
    }

    // Get sentences by type (Positive / Negative / Verbal / Wh)
    @GetMapping("/type/{type}")
    public List<ToBeHaveFutureSentences> GetToBeHaveFutureByType(@PathVariable String type) {
        return service.GetToBeHaveFutureByType(type);
    }
}

