
package com.example.EnglishApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import com.example.EnglishApp.entity.ToBeThereisSentences;

import java.util.List;

@Repository
public interface ToBeThereisSentencesRepository extends JpaRepository<ToBeThereisSentences, Long> {

    // ✅ Call stored procedure to get all
    @Transactional(readOnly = true)
    @Query(value = "CALL GetAllToBeThereis()", nativeQuery = true)
    List<ToBeThereisSentences> GetAllToBeThereis();

    // ✅ Call stored procedure to get by type
    @Transactional(readOnly = true)
    @Query(value = "CALL GetToBeThereisByType(:typeName)", nativeQuery = true)
    List<ToBeThereisSentences> GetToBeThereisByType(String typeName);

}
