
package com.example.EnglishApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import com.example.EnglishApp.entity.PresentContinuousSentences;

import java.util.List;

@Repository
public interface PresentContinuousSentencesRepository extends JpaRepository<PresentContinuousSentences, Long> {

    // ✅ Call stored procedure to get all
    @Transactional(readOnly = true)
    @Query(value = "CALL GetAllPresentContinuous()", nativeQuery = true)
    List<PresentContinuousSentences> GetAllPresentContinuous();

    // ✅ Call stored procedure to get by type
    @Transactional(readOnly = true)
    @Query(value = "CALL GetPresentContinuousByType(:typeName)", nativeQuery = true)
    List<PresentContinuousSentences> GetPresentContinuousByType(String typeName);
}

