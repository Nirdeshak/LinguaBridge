

package com.example.EnglishApp.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.EnglishApp.entity.SimplePastSentences;
import com.example.EnglishApp.repository.SimplePastSentencesRepository;

import java.util.List;

@Service
public class SimplePastSentencesService {

    private final SimplePastSentencesRepository repository;

    public SimplePastSentencesService(SimplePastSentencesRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)  // ✅ keeps transaction open
    public List<SimplePastSentences> GetAllPastTense() {
        return repository.GetAllPastTense();
    }

    @Transactional(readOnly = true)
    public List<SimplePastSentences> GetSimplePastByType(String type) {
        return repository.GetSimplePastByType(type);
    }
}


