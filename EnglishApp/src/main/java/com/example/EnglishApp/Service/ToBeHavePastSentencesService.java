
package com.example.EnglishApp.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.EnglishApp.entity.ToBeHavePastSentences;
import com.example.EnglishApp.repository.ToBeHavePastSentencesRepository;

import java.util.List;

@Service
public class ToBeHavePastSentencesService {

    private final ToBeHavePastSentencesRepository repository;

    public ToBeHavePastSentencesService(ToBeHavePastSentencesRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)  // ✅ keeps transaction open
    public List<ToBeHavePastSentences> GetAllToBeHavePastSentences() {
        return repository.getAllToBeHavePastSentences();
    }

    @Transactional(readOnly = true)
    public List<ToBeHavePastSentences> GetToBeHavePastByType(String type) {
        return repository.getToBeHavePastByType(type);
    }
}


