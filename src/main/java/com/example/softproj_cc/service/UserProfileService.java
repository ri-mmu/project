package com.example.softproj_cc.service;

import com.example.softproj_cc.dto.UserProfileRequest;
import com.example.softproj_cc.entity.User;
import com.example.softproj_cc.entity.UserProfile;
import com.example.softproj_cc.repository.UserProfileRepository;
import com.example.softproj_cc.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final UserRepository userRepository;

    public UserProfileService(UserProfileRepository userProfileRepository,
                              UserRepository userRepository) {
        this.userProfileRepository = userProfileRepository;
        this.userRepository = userRepository;
    }

    /**
     * @param userId  JWT에서 꺼낸, 인증된 사용자의 ID
     * @param request Body로 받은 UserProfileRequest DTO
     */
    @Transactional
    public UserProfile createUserProfile(Long userId, UserProfileRequest request) {
        // 1) userId 로 User 조회
        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new IllegalArgumentException("유효하지 않은 사용자 ID: " + userId)
                );

        // 2) UserProfile 매핑
        UserProfile profile = new UserProfile();
        profile.setUser(user);
        profile.setNickname(request.getNickname());
        profile.setAge(request.getAge());
        profile.setBio(request.getBio());
        profile.setMajor(request.getMajor());
        profile.setPhotoUrl(request.getPhotoUrl());
        // TODO: interests, introduction 등 추가 필드 세팅

        // 3) 저장 및 반환
        return userProfileRepository.save(profile);
    }
}