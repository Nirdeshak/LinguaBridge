
package com.example.EnglishApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import com.example.EnglishApp.entity.ThereisFutureSentences;
import com.example.EnglishApp.entity.ThereisPastSentences;

import java.util.List;

@Repository
public interface ThereisFutureSentencesRepository extends JpaRepository<ThereisPastSentences, Long> {

    // ✅ Call stored procedure to get all
    @Transactional(readOnly = true)
    @Query(value = "CALL GetAllThereisFuture()", nativeQuery = true)
    List<ThereisFutureSentences> GetAllThereisFuture();

    // ✅ Call stored procedure to get by type
    @Transactional(readOnly = true)
    @Query(value = "CALL GetThereisFutureByType(:typeName)", nativeQuery = true)
    List<ThereisFutureSentences> GetThereisFutureByType(String typeName);
}

