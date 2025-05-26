package com.example.softproj_cc.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@IdClass(MatchId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user_match")
public class Match {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_a", referencedColumnName = "id")
    private User userA;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_b", referencedColumnName = "id")
    private User userB;

    @Column(name = "matched_at")
    private LocalDateTime matchedAt;

    @Column(name = "is_matched", nullable = false)
    private Boolean isMatched;

    @PrePersist
    public void prePersist() {
        if (matchedAt == null) {
            matchedAt = LocalDateTime.now();
        }
        if (isMatched == null) {
            isMatched = false;
        }
    }
}