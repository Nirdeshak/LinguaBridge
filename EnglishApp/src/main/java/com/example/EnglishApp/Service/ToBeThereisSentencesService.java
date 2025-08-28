package com.example.EnglishApp.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.EnglishApp.entity.ToBeThereisSentences;
import com.example.EnglishApp.repository.ToBeThereisSentencesRepository;

import java.util.List;

@Service
public class ToBeThereisSentencesService {

    private final ToBeThereisSentencesRepository repository;

    public ToBeThereisSentencesService(ToBeThereisSentencesRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)  // ✅ keeps transaction open
    public List<ToBeThereisSentences> GetAllToBeThereis() {
        return repository.GetAllToBeThereis();
    }

    @Transactional(readOnly = true)
    public List<ToBeThereisSentences> GetToBeThereisByType(String type) {
        return repository.GetToBeThereisByType(type);
    }
}
