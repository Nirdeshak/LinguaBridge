package com.example.EnglishApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import com.example.EnglishApp.entity.ToBePastSentence;

import java.util.List;

@Repository
public interface ToBePastSentenceRepository extends JpaRepository<ToBePastSentence, Long> {

    // ✅ Call stored procedure to get all
    @Transactional(readOnly = true)
    @Query(value = "CALL GetAllToBePast()", nativeQuery = true)
    List<ToBePastSentence> getAllToBePast();

    // ✅ Call stored procedure to get by type
    @Transactional(readOnly = true)
    @Query(value = "CALL GetToBePastByType(:typeName)", nativeQuery = true)
    List<ToBePastSentence> getToBePastByType(String typeName);
}

