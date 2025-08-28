
package com.example.EnglishApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import com.example.EnglishApp.entity.SimplePastSentences;

import java.util.List;

@Repository
public interface SimplePastSentencesRepository extends JpaRepository<SimplePastSentences, Long> {

    // ✅ Call stored procedure to get all
    @Transactional(readOnly = true)
    @Query(value = "CALL GetAllPastTense()", nativeQuery = true)
    List<SimplePastSentences> GetAllPastTense();

    // ✅ Call stored procedure to get by type
    @Transactional(readOnly = true)
    @Query(value = "CALL GetSimplePastByType(:typeName)", nativeQuery = true)
    List<SimplePastSentences> GetSimplePastByType(String typeName);
}

