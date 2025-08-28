

package com.example.EnglishApp.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.EnglishApp.entity.ThereisFutureSentences;
import com.example.EnglishApp.repository.ThereisFutureSentencesRepository;

import java.util.List;

@Service
public class ThereisFutureSentencesService {

    private final ThereisFutureSentencesRepository repository;

    public ThereisFutureSentencesService(ThereisFutureSentencesRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)  // ✅ keeps transaction open
    public List<ThereisFutureSentences> GetAllThereisFuture() {
        return repository.GetAllThereisFuture();
    }

    @Transactional(readOnly = true)
    public List<ThereisFutureSentences> GetThereisFutureByType(String type) {
        return repository.GetThereisFutureByType(type);
    }
}

