
package com.example.EnglishApp.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.EnglishApp.entity.SimpleFutureSentences;
import com.example.EnglishApp.repository.SimpleFutureSentencesRepository;

import java.util.List;

@Service
public class SimpleFutureSentencesService {

    private final SimpleFutureSentencesRepository repository;

    public SimpleFutureSentencesService(SimpleFutureSentencesRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)  // ✅ keeps transaction open
    public List<SimpleFutureSentences> GetAllFutureTense() {
        return repository.GetAllFutureTense();
    }

    @Transactional(readOnly = true)
    public List<SimpleFutureSentences> GetSimpleFutureByType(String type) {
        return repository.GetSimpleFutureByType(type);
    }
}


