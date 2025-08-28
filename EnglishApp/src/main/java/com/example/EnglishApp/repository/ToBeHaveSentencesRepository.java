
package com.example.EnglishApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import com.example.EnglishApp.entity.ToBeHaveSentences;

import java.util.List;

@Repository
public interface ToBeHaveSentencesRepository extends JpaRepository<ToBeHaveSentences, Long> {

    // ✅ Call stored procedure to get all
    @Transactional(readOnly = true)
    @Query(value = "CALL GetAllToBeHaveSentences()", nativeQuery = true)
    List<ToBeHaveSentences> getAllToBeHaveSentences();

    // ✅ Call stored procedure to get by type
    @Transactional(readOnly = true)
    @Query(value = "CALL GetToBeHaveSentencesByType(:typeName)", nativeQuery = true)
    List<ToBeHaveSentences> GetToBeHaveSentencesByType(String typeName);
}

