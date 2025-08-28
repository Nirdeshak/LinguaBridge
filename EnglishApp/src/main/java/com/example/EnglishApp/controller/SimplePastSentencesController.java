
package com.example.EnglishApp.controller;

import org.springframework.web.bind.annotation.*;

import com.example.EnglishApp.Service.SimplePastSentencesService;
import com.example.EnglishApp.entity.SimplePastSentences;

import java.util.List;

@RestController
@RequestMapping("/api/tobe/simple/past")
@CrossOrigin(origins = "http://localhost:5174")  // 👈 allow frontend

public class SimplePastSentencesController {

    private final SimplePastSentencesService service;

    public SimplePastSentencesController(SimplePastSentencesService service) {
        this.service = service;
    }

    // Get all sentences
    @GetMapping("/all")
    public List<SimplePastSentences> GetAllPastTense() {
        return service.GetAllPastTense();
    }

    // Get sentences by type (Positive / Negative / Verbal / Wh)
    @GetMapping("/type/{type}")
    public List<SimplePastSentences> GetSimplePastByType(@PathVariable String type) {
        return service.GetSimplePastByType(type);
    }
}

