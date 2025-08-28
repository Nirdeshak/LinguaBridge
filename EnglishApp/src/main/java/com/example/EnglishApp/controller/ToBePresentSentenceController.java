package com.example.EnglishApp.controller;

import org.springframework.web.bind.annotation.*;
import com.example.EnglishApp.Service.ToBePresentSentencesService;
import com.example.EnglishApp.entity.ToBePresentSentences;

import java.util.List;

@RestController
@RequestMapping("/api/tobe")
@CrossOrigin(origins = "http://localhost:5174")  // 👈 allow frontend

public class ToBePresentSentenceController {

    private final ToBePresentSentencesService service;

    public ToBePresentSentenceController(ToBePresentSentencesService service) {
        this.service = service;
    }

    // Get all sentences
    @GetMapping("/all")
    public List<ToBePresentSentences> GetAllToBePresent() {
        return service.GetAllToBePresent();
    }

    // Get sentences by type (Positive / Negative / Verbal / Wh)
    @GetMapping("/type/{type}")
    public List<ToBePresentSentences> GetToBePresentByType(@PathVariable String type) {
        return service.GetToBePresentByType(type);
    }
}
