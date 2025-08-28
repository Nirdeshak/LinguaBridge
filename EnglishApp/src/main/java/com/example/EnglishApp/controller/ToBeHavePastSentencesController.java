
package com.example.EnglishApp.controller;

import org.springframework.web.bind.annotation.*;

import com.example.EnglishApp.Service.ToBeHavePastSentencesService;
import com.example.EnglishApp.entity.ToBeHavePastSentences;

import java.util.List;

@RestController
@RequestMapping("/api/tobe/have/past")
@CrossOrigin(origins = "http://localhost:5174")  // 👈 allow frontend

public class ToBeHavePastSentencesController {

    private final ToBeHavePastSentencesService service;

    public ToBeHavePastSentencesController(ToBeHavePastSentencesService service) {
        this.service = service;
    }

    // Get all sentences
    @GetMapping("/all")
    public List<ToBeHavePastSentences> GetAllToBeHavePastSentences() {
        return service.GetAllToBeHavePastSentences();
    }

    // Get sentences by type (Positive / Negative / Verbal / Wh)
    @GetMapping("/type/{type}")
    public List<ToBeHavePastSentences> GetToBeHavePastByType(@PathVariable String type) {
        return service.GetToBeHavePastByType(type);
    }
}

