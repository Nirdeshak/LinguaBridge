

package com.example.EnglishApp.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.EnglishApp.entity.ToBeHaveFutureSentences;
import com.example.EnglishApp.repository.ToBeHaveFutureSentencesRepository;

import java.util.List;

@Service
public class ToBeHaveFutureSentencesService {

    private final ToBeHaveFutureSentencesRepository repository;

    public ToBeHaveFutureSentencesService(ToBeHaveFutureSentencesRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)  // ✅ keeps transaction open
    public List<ToBeHaveFutureSentences> GetAllToBeHaveFuture() {
        return repository.GetAllToBeHaveFuture();
    }

    @Transactional(readOnly = true)
    public List<ToBeHaveFutureSentences> GetToBeHaveFutureByType(String type) {
        return repository.GetToBeHaveFutureByType(type);
    }
}


