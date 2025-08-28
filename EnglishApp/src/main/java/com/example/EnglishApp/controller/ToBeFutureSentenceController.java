
package com.example.EnglishApp.controller;

import org.springframework.web.bind.annotation.*;

import com.example.EnglishApp.Service.ToBeFutureSentenceService;
import com.example.EnglishApp.entity.ToBeFutureSentence;

import java.util.List;

@RestController
@RequestMapping("/api/tobe/future")
@CrossOrigin(origins = "http://localhost:5174")  // 👈 allow frontend

public class ToBeFutureSentenceController {

    private final ToBeFutureSentenceService service;

    public ToBeFutureSentenceController(ToBeFutureSentenceService service) {
        this.service = service;
    }

    // Get all sentences
    @GetMapping("/all")
    public List<ToBeFutureSentence> GetAllToBeFuture() {
        return service.GetAllToBeFuture();
    }

    // Get sentences by type (Positive / Negative / Verbal / Wh)
    @GetMapping("/type/{type}")
    public List<ToBeFutureSentence> GetToBeFutureByType(@PathVariable String type) {
        return service.GetToBeFutureByType(type);
    }
}
