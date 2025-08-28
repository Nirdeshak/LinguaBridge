
package com.example.EnglishApp.controller;

import org.springframework.web.bind.annotation.*;
import com.example.EnglishApp.Service.ToBeThereisSentencesService;
import com.example.EnglishApp.entity.ToBeThereisSentences;

import java.util.List;

@RestController
@RequestMapping("/api/tobe/thereis")
@CrossOrigin(origins = "http://localhost:5174")  // 👈 allow frontend

public class ToBeThereisSentencesController {

    private final ToBeThereisSentencesService service;

    public ToBeThereisSentencesController(ToBeThereisSentencesService service) {
        this.service = service;
    }

    // Get all sentences
    @GetMapping("/all")
    public List<ToBeThereisSentences> GetAllToBeThereis() {
        return service.GetAllToBeThereis();
    }

    // Get sentences by type (Positive / Negative / Verbal / Wh)
    @GetMapping("/type/{type}")
    public List<ToBeThereisSentences> GetToBeThereisByType(@PathVariable String type) {
        return service.GetToBeThereisByType(type);
    }
}
