
package com.example.EnglishApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import com.example.EnglishApp.entity.ThereisPastSentences;

import java.util.List;

@Repository
public interface ThereisPastSentencesRepository extends JpaRepository<ThereisPastSentences, Long> {

    // ✅ Call stored procedure to get all
    @Transactional(readOnly = true)
    @Query(value = "CALL GetAllThereisPast()", nativeQuery = true)
    List<ThereisPastSentences> GetAllThereisPast();

    // ✅ Call stored procedure to get by type
    @Transactional(readOnly = true)
    @Query(value = "CALL GetThereisPastByType(:typeName)", nativeQuery = true)
    List<ThereisPastSentences> GetThereisPastByType(String typeName);
}

