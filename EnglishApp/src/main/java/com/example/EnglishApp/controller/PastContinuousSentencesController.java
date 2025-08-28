
package com.example.EnglishApp.controller;

import org.springframework.web.bind.annotation.*;

import com.example.EnglishApp.Service.PastContinuousSentencesService;
import com.example.EnglishApp.entity.PastContinuousSentences;

import java.util.List;

@RestController
@RequestMapping("/api/tobe/past/continuos")
@CrossOrigin(origins = "http://localhost:5174")  // 👈 allow frontend

public class PastContinuousSentencesController {

    private final PastContinuousSentencesService service;

    public PastContinuousSentencesController(PastContinuousSentencesService service) {
        this.service = service;
    }

    // Get all sentences
    @GetMapping("/all")
    public List<PastContinuousSentences> GetAllPastContinuous() {
        return service.GetAllPastContinuous();
    }

    // Get sentences by type (Positive / Negative / Verbal / Wh)
    @GetMapping("/type/{type}")
    public List<PastContinuousSentences> GetPastContinuousByType(@PathVariable String type) {
        return service.GetPastContinuousByType(type);
    }
}


