
package com.example.EnglishApp.controller;

import org.springframework.web.bind.annotation.*;

import com.example.EnglishApp.Service.ToBeHaveSentencesService;
import com.example.EnglishApp.entity.ToBeHaveSentences;

import java.util.List;

@RestController
@RequestMapping("/api/tobe/have")
@CrossOrigin(origins = "http://localhost:5174")  // 👈 allow frontend

public class ToBeHaveSentencesController {

    private final ToBeHaveSentencesService service;

    public ToBeHaveSentencesController(ToBeHaveSentencesService service) {
        this.service = service;
    }

    // Get all sentences
    @GetMapping("/all")
    public List<ToBeHaveSentences> GetAllToBeHaveSentences() {
        return service.GetAllToBeHaveSentences();
    }

    // Get sentences by type (Positive / Negative / Verbal / Wh)
    @GetMapping("/type/{type}")
    public List<ToBeHaveSentences> GetToBeHaveSentencesByType(@PathVariable String type) {
        return service.GetToBeHaveSentencesByType(type);
    }
}
