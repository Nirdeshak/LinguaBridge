
package com.example.EnglishApp.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ToBeFutureSentence")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToBeFutureSentence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sentenceType; // Positive / Negative / Verbal / Wh
    private String question; // English sentence
    private String correctAnswer; // Marathi translation

    @Column(columnDefinition = "json")
    private String options; // JSON array as String

    private LocalDateTime createdAt; // TIMESTAMP mapped correctly
}
