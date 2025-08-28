
package com.example.EnglishApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import com.example.EnglishApp.entity.ToBeHavePastSentences;

import java.util.List;

@Repository
public interface ToBeHavePastSentencesRepository extends JpaRepository<ToBeHavePastSentences, Long> {

    // ✅ Call stored procedure to get all
    @Transactional(readOnly = true)
    @Query(value = "CALL GetAllToBeHavePastSentences()", nativeQuery = true)
    List<ToBeHavePastSentences> getAllToBeHavePastSentences();

    // ✅ Call stored procedure to get by type
    @Transactional(readOnly = true)
    @Query(value = "CALL GetToBeHavePastByType(:typeName)", nativeQuery = true)
    List<ToBeHavePastSentences> getToBeHavePastByType(String typeName);
}

