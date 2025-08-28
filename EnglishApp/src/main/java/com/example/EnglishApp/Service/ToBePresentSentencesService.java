package com.example.EnglishApp.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.EnglishApp.entity.ToBePresentSentences;
import com.example.EnglishApp.repository.ToBePresentSentenceRepository;

import java.util.List;

@Service
public class ToBePresentSentencesService {

    private final ToBePresentSentenceRepository repository;

    public ToBePresentSentencesService(ToBePresentSentenceRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)  // ✅ keeps transaction open
    public List<ToBePresentSentences> GetAllToBePresent() {
        return repository.GetAllToBePresent();
    }

    @Transactional(readOnly = true)
    public List<ToBePresentSentences> GetToBePresentByType(String type) {
        return repository.GetToBePresentByType(type);
    }
}
