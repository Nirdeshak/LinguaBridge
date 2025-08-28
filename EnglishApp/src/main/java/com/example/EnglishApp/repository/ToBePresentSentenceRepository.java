package com.example.EnglishApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import com.example.EnglishApp.entity.ToBePresentSentences;

import java.util.List;

@Repository
public interface ToBePresentSentenceRepository extends JpaRepository<ToBePresentSentences, Long> {

    // ✅ Call stored procedure to get all
    @Transactional(readOnly = true)
    @Query(value = "CALL GetAllToBePresent()", nativeQuery = true)
    List<ToBePresentSentences> GetAllToBePresent();

    // ✅ Call stored procedure to get by type
    @Transactional(readOnly = true)
    @Query(value = "CALL GetToBePresentByType(:typeName)", nativeQuery = true)
    List<ToBePresentSentences> GetToBePresentByType(String typeName);
}
