
package com.example.EnglishApp.controller;

import org.springframework.web.bind.annotation.*;

import com.example.EnglishApp.Service.ToBePastSentenceService;
import com.example.EnglishApp.entity.ToBePastSentence;

import java.util.List;

@RestController
@RequestMapping("/api/tobe/past")
@CrossOrigin(origins = "http://localhost:5174")  // 👈 allow frontend

public class ToBePastSentenceController {

    private final ToBePastSentenceService service;

    public ToBePastSentenceController(ToBePastSentenceService service) {
        this.service = service;
    }

    // Get all sentences
    @GetMapping("/all")
    public List<ToBePastSentence> GetAllToBePast() {
        return service.GetAllToBePast();
    }

    // Get sentences by type (Positive / Negative / Verbal / Wh)
    @GetMapping("/type/{type}")
    public List<ToBePastSentence> GetToBePastByType(@PathVariable String type) {
        return service.GetToBePastByType(type);
    }
}
