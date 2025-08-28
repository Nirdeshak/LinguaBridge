
package com.example.EnglishApp.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.EnglishApp.entity.ThereisPastSentences;
import com.example.EnglishApp.repository.ThereisPastSentencesRepository;

import java.util.List;

@Service
public class ThereisPastSentencesService {

    private final ThereisPastSentencesRepository repository;

    public ThereisPastSentencesService(ThereisPastSentencesRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)  // ✅ keeps transaction open
    public List<ThereisPastSentences> GetAllThereisPast() {
        return repository.GetAllThereisPast();
    }

    @Transactional(readOnly = true)
    public List<ThereisPastSentences> GetThereisPastByType(String type) {
        return repository.GetThereisPastByType(type);
    }
}

