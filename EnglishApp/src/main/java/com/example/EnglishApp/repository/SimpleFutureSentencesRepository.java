
package com.example.EnglishApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import com.example.EnglishApp.entity.SimpleFutureSentences;

import java.util.List;

@Repository
public interface SimpleFutureSentencesRepository extends JpaRepository<SimpleFutureSentences, Long> {

    // ✅ Call stored procedure to get all
    @Transactional(readOnly = true)
    @Query(value = "CALL GetAllFutureTense()", nativeQuery = true)
    List<SimpleFutureSentences> GetAllFutureTense();

    // ✅ Call stored procedure to get by type
    @Transactional(readOnly = true)
    @Query(value = "CALL GetSimpleFutureByType(:typeName)", nativeQuery = true)
    List<SimpleFutureSentences> GetSimpleFutureByType(String typeName);
}

