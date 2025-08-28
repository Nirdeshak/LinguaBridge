
package com.example.EnglishApp.controller;

import org.springframework.web.bind.annotation.*;

import com.example.EnglishApp.Service.PresentContinuousSentencesService;
import com.example.EnglishApp.entity.PresentContinuousSentences;

import java.util.List;

@RestController
@RequestMapping("/api/tobe/present/continuos")
@CrossOrigin(origins = "http://localhost:5174")  // 👈 allow frontend

public class PresentContinuousSentencesController {

    private final PresentContinuousSentencesService service;

    public PresentContinuousSentencesController(PresentContinuousSentencesService service) {
        this.service = service;
    }

    // Get all sentences
    @GetMapping("/all")
    public List<PresentContinuousSentences> GetAllPresentContinuous() {
        return service.GetAllPresentContinuous();
    }

    // Get sentences by type (Positive / Negative / Verbal / Wh)
    @GetMapping("/type/{type}")
    public List<PresentContinuousSentences> GetPresentContinuousByType(@PathVariable String type) {
        return service.GetPresentContinuousByType(type);
    }
}

