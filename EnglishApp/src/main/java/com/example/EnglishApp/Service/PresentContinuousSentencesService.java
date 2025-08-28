
package com.example.EnglishApp.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.EnglishApp.entity.PresentContinuousSentences;
import com.example.EnglishApp.repository.PresentContinuousSentencesRepository;

import java.util.List;

@Service
public class PresentContinuousSentencesService {

    private final PresentContinuousSentencesRepository repository;

    public PresentContinuousSentencesService(PresentContinuousSentencesRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)  // ✅ keeps transaction open
    public List<PresentContinuousSentences> GetAllPresentContinuous() {
        return repository.GetAllPresentContinuous();
    }

    @Transactional(readOnly = true)
    public List<PresentContinuousSentences> GetPresentContinuousByType(String type) {
        return repository.GetPresentContinuousByType(type);
    }
}



