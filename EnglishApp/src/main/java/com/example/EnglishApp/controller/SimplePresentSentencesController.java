
package com.example.EnglishApp.controller;

import org.springframework.web.bind.annotation.*;

import com.example.EnglishApp.Service.SimplePresentSentencesService;
import com.example.EnglishApp.entity.SimplePresentSentences;

import java.util.List;

@RestController
@RequestMapping("/api/tobe/simple/present")
@CrossOrigin(origins = "http://localhost:5174")  // 👈 allow frontend

public class SimplePresentSentencesController {

    private final SimplePresentSentencesService service;

    public SimplePresentSentencesController(SimplePresentSentencesService service) {
        this.service = service;
    }

    // Get all sentences
    @GetMapping("/all")
    public List<SimplePresentSentences> GetAllSimpleTense() {
        return service.GetAllSimpleTense();
    }

    // Get sentences by type (Positive / Negative / Verbal / Wh)
    @GetMapping("/type/{type}")
    public List<SimplePresentSentences> GetSimplePresentByType(@PathVariable String type) {
        return service.GetSimplePresentByType(type);
    }
}

