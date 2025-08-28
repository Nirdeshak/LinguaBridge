package com.example.EnglishApp.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.EnglishApp.entity.ToBePastSentence;
import com.example.EnglishApp.repository.ToBePastSentenceRepository;

import java.util.List;

@Service
public class ToBePastSentenceService {

    private final ToBePastSentenceRepository repository;

    public ToBePastSentenceService(ToBePastSentenceRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)  // ✅ keeps transaction open
    public List<ToBePastSentence> GetAllToBePast() {
        return repository.getAllToBePast();
    }

    @Transactional(readOnly = true)
    public List<ToBePastSentence> GetToBePastByType(String type) {
        return repository.getToBePastByType(type);
    }
}

