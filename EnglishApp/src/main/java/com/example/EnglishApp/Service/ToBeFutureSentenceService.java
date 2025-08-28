
package com.example.EnglishApp.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.EnglishApp.entity.ToBeFutureSentence;
import com.example.EnglishApp.repository.ToBeFutureSentenceRepository;

import java.util.List;

@Service
public class ToBeFutureSentenceService {

    private final ToBeFutureSentenceRepository repository;

    public ToBeFutureSentenceService(ToBeFutureSentenceRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)  // ✅ keeps transaction open
    public List<ToBeFutureSentence> GetAllToBeFuture() {
        return repository.getAllToBeFuture();
    }

    @Transactional(readOnly = true)
    public List<ToBeFutureSentence> GetToBeFutureByType(String type) {
        return repository.getToBeFutureByType(type);
    }
}

