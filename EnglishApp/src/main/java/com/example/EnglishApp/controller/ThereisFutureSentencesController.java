
package com.example.EnglishApp.controller;

import org.springframework.web.bind.annotation.*;

import com.example.EnglishApp.Service.ThereisFutureSentencesService;
import com.example.EnglishApp.entity.ThereisFutureSentences;

import java.util.List;

@RestController
@RequestMapping("/api/tobe/thereis/future")
@CrossOrigin(origins = "http://localhost:5174")  // 👈 allow frontend

public class ThereisFutureSentencesController {

    private final ThereisFutureSentencesService service;

    public ThereisFutureSentencesController(ThereisFutureSentencesService service) {
        this.service = service;
    }

    // Get all sentences
    @GetMapping("/all")
    public List<ThereisFutureSentences> GetAllThereisFuture() {
        return service.GetAllThereisFuture();
    }

    // Get sentences by type (Positive / Negative / Verbal / Wh)
    @GetMapping("/type/{type}")
    public List<ThereisFutureSentences> GetThereisFutureByType(@PathVariable String type) {
        return service.GetThereisFutureByType(type);
    }
}
