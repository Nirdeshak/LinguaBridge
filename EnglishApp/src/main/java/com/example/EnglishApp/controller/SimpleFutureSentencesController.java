
package com.example.EnglishApp.controller;

import org.springframework.web.bind.annotation.*;

import com.example.EnglishApp.Service.SimpleFutureSentencesService;
import com.example.EnglishApp.entity.SimpleFutureSentences;

import java.util.List;

@RestController
@RequestMapping("/api/tobe/simple/future")
@CrossOrigin(origins = "http://localhost:5174")  // 👈 allow frontend

public class SimpleFutureSentencesController {

    private final SimpleFutureSentencesService service;

    public SimpleFutureSentencesController(SimpleFutureSentencesService service) {
        this.service = service;
    }

    // Get all sentences
    @GetMapping("/all")
    public List<SimpleFutureSentences> GetAllFutureTense() {
        return service.GetAllFutureTense();
    }

    // Get sentences by type (Positive / Negative / Verbal / Wh)
    @GetMapping("/type/{type}")
    public List<SimpleFutureSentences> GetSimpleFutureByType(@PathVariable String type) {
        return service.GetSimpleFutureByType(type);
    }
}

