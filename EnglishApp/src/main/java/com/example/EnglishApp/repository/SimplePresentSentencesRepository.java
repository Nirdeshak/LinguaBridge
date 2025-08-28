
package com.example.EnglishApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import com.example.EnglishApp.entity.SimplePresentSentences;

import java.util.List;

@Repository
public interface SimplePresentSentencesRepository extends JpaRepository<SimplePresentSentences, Long> {

    // ✅ Call stored procedure to get all
    @Transactional(readOnly = true)
    @Query(value = "CALL GetAllSimpleTense()", nativeQuery = true)
    List<SimplePresentSentences> GetAllSimpleTense();

    // ✅ Call stored procedure to get by type
    @Transactional(readOnly = true)
    @Query(value = "CALL GetSimplePresentByType(:typeName)", nativeQuery = true)
    List<SimplePresentSentences> GetSimplePresentByType(String typeName);
}

