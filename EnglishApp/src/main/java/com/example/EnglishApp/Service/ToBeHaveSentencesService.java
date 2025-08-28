
package com.example.EnglishApp.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.EnglishApp.entity.ToBeHaveSentences;
import com.example.EnglishApp.repository.ToBeHaveSentencesRepository;

import java.util.List;

@Service
public class ToBeHaveSentencesService {

    private final ToBeHaveSentencesRepository repository;

    public ToBeHaveSentencesService(ToBeHaveSentencesRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)  // ✅ keeps transaction open
    public List<ToBeHaveSentences> GetAllToBeHaveSentences() {
        return repository.getAllToBeHaveSentences();
    }

    @Transactional(readOnly = true)
    public List<ToBeHaveSentences> GetToBeHaveSentencesByType(String type) {
        return repository.GetToBeHaveSentencesByType(type);
    }
}

