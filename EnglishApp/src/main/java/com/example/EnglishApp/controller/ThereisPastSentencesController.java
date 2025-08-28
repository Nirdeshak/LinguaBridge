

package com.example.EnglishApp.controller;

import org.springframework.web.bind.annotation.*;

import com.example.EnglishApp.Service.ThereisPastSentencesService;
import com.example.EnglishApp.entity.ThereisPastSentences;

import java.util.List;

@RestController
@RequestMapping("/api/tobe/thereis/past")
@CrossOrigin(origins = "http://localhost:5174")  // 👈 allow frontend

public class ThereisPastSentencesController {

    private final ThereisPastSentencesService service;

    public ThereisPastSentencesController(ThereisPastSentencesService service) {
        this.service = service;
    }

    // Get all sentences
    @GetMapping("/all")
    public List<ThereisPastSentences> GetAllThereisPast() {
        return service.GetAllThereisPast();
    }

    // Get sentences by type (Positive / Negative / Verbal / Wh)
    @GetMapping("/type/{type}")
    public List<ThereisPastSentences> GetThereisPastByType(@PathVariable String type) {
        return service.GetThereisPastByType(type);
    }
}
