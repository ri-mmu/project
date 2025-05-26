/*// RecommendationService.java
package com.example.softproj_cc.service;

import com.example.softproj_cc.dto.RecommendationDto;
import com.example.softproj_cc.entity.User;
import com.example.softproj_cc.repository.UserInterestRepository;
import com.example.softproj_cc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecommendationService {
    private final UserRepository userRepository;
    private final UserInterestRepository userInterestRepo;

    public List<RecommendationDto> recommend(Long meId, String desiredMajor, int limit) {
        // 1) 내 관심사 ID 목록 조회
        List<Long> myInterestIds = userInterestRepo
                .findByUserId(meId)
                .stream()
                .map(ui -> ui.getInterest().getId())
                .collect(Collectors.toList());

        if (myInterestIds.isEmpty()) {
            return List.of(); // 관심사가 없으면 빈 리스트
        }

        // 2) 추천 대상 조회
        var users = userRepository.findRecommended(
                meId, desiredMajor, myInterestIds, PageRequest.of(0, limit)
        );

        // 3) DTO 변환
        return users.stream().map(u -> {
            RecommendationDto dto = new RecommendationDto();
            dto.setUsername(u.getUsername());
            dto.setNickname(u.getProfile().getNickname());
            dto.setPhotoUrl(u.getProfile().getPhotoUrl());
            dto.setInterests(u.getProfile().getInterests().stream()
                    .map(ui -> ui.getInterest().getName())
                    .collect(Collectors.toList()));
            return dto;
        }).collect(Collectors.toList());
    }
}
*/