
package com.example.EnglishApp.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.EnglishApp.entity.PastContinuousSentences;
import com.example.EnglishApp.repository.PastContinuousSentencesRepository;

import java.util.List;

@Service
public class PastContinuousSentencesService {

    private final PastContinuousSentencesRepository repository;

    public PastContinuousSentencesService(PastContinuousSentencesRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)  // ✅ keeps transaction open
    public List<PastContinuousSentences> GetAllPastContinuous() {
        return repository.GetAllPastContinuous();
    }

    @Transactional(readOnly = true)
    public List<PastContinuousSentences> GetPastContinuousByType(String type) {
        return repository.GetPastContinuousByType(type);
    }
}




