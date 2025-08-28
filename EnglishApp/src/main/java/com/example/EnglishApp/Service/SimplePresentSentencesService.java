
package com.example.EnglishApp.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.EnglishApp.entity.SimplePresentSentences;
import com.example.EnglishApp.repository.SimplePresentSentencesRepository;

import java.util.List;

@Service
public class SimplePresentSentencesService {

    private final SimplePresentSentencesRepository repository;

    public SimplePresentSentencesService(SimplePresentSentencesRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)  // ✅ keeps transaction open
    public List<SimplePresentSentences> GetAllSimpleTense() {
        return repository.GetAllSimpleTense();
    }

    @Transactional(readOnly = true)
    public List<SimplePresentSentences> GetSimplePresentByType(String type) {
        return repository.GetSimplePresentByType(type);
    }
}

