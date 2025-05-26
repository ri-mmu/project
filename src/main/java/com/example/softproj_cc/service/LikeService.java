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
public class LikeService {

    private final MatchRepository matchRepo;
    private final UserRepository userRepo;

    @Transactional
    public void respondLike(Long senderId, Long receiverId, String response) {
        User sender = userRepo.findById(senderId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid senderId"));
        User receiver = userRepo.findById(receiverId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid receiverId"));

        if (matchRepo.existsByUserAAndUserB(sender, receiver)) return;

        Match match = Match.builder()
                .userA(sender)
                .userB(receiver)
                .isMatched(false)
                .matchedAt(LocalDateTime.now())
                .build();

        matchRepo.save(match);
    }
}