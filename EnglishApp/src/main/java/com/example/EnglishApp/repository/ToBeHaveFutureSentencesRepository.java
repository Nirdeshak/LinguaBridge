

package com.example.EnglishApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import com.example.EnglishApp.entity.ToBeHaveFutureSentences;

import java.util.List;

@Repository
public interface ToBeHaveFutureSentencesRepository extends JpaRepository<ToBeHaveFutureSentences, Long> {

    // ✅ Call stored procedure to get all
    @Transactional(readOnly = true)
    @Query(value = "CALL GetAllToBeHaveFuture()", nativeQuery = true)
    List<ToBeHaveFutureSentences> GetAllToBeHaveFuture();

    // ✅ Call stored procedure to get by type
    @Transactional(readOnly = true)
    @Query(value = "CALL GetToBeHaveFutureByType(:typeName)", nativeQuery = true)
    List<ToBeHaveFutureSentences> GetToBeHaveFutureByType(String typeName);
}

