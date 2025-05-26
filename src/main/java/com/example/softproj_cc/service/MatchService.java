package com.example.softproj_cc.service;

import com.example.softproj_cc.entity.Match;
import com.example.softproj_cc.entity.User;
import com.example.softproj_cc.repository.MatchRepository;
import com.example.softproj_cc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepo;
    private final UserRepository userRepo;

    @Transactional
    public void likeUser(Long fromId, Long toId) {
        User fromUser = userRepo.findById(fromId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid fromId"));
        User toUser = userRepo.findById(toId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid toId"));

        if (matchRepo.existsByUserAAndUserB(fromUser, toUser)) return;

        Match match = Match.builder()
                .userA(fromUser)
                .userB(toUser)
                .matchedAt(LocalDateTime.now())
                .build();
        matchRepo.save(match);
    }
}