package com.example.softproj_cc.repository;

import com.example.softproj_cc.entity.Match;
import com.example.softproj_cc.entity.MatchId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, MatchId> {
    boolean existsByUserAAndUserB(com.example.softproj_cc.entity.User userA, com.example.softproj_cc.entity.User userB);
}