

package com.example.EnglishApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import com.example.EnglishApp.entity.ToBeFutureSentence;

import java.util.List;

@Repository
public interface ToBeFutureSentenceRepository extends JpaRepository<ToBeFutureSentence, Long> {

    // ✅ Call stored procedure to get all
    @Transactional(readOnly = true)
    @Query(value = "CALL GetAllToBeFuture()", nativeQuery = true)
    List<ToBeFutureSentence> getAllToBeFuture();

    // ✅ Call stored procedure to get by type
    @Transactional(readOnly = true)
    @Query(value = "CALL GetToBeFutureByType(:typeName)", nativeQuery = true)
    List<ToBeFutureSentence> getToBeFutureByType(String typeName);
}

