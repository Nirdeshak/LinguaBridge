
package com.example.EnglishApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import com.example.EnglishApp.entity.PastContinuousSentences;

import java.util.List;

@Repository
public interface PastContinuousSentencesRepository extends JpaRepository<PastContinuousSentences, Long> {

    // ✅ Call stored procedure to get all
    @Transactional(readOnly = true)
    @Query(value = "CALL GetAllPastContinuous()", nativeQuery = true)
    List<PastContinuousSentences> GetAllPastContinuous();

    // ✅ Call stored procedure to get by type
    @Transactional(readOnly = true)
    @Query(value = "CALL GetPastContinuousByType(:typeName)", nativeQuery = true)
    List<PastContinuousSentences> GetPastContinuousByType(String typeName);
}


