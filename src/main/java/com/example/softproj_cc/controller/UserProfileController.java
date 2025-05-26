package com.example.softproj_cc.controller;

import com.example.softproj_cc.dto.UserProfileRequest;
import com.example.softproj_cc.entity.User;
import com.example.softproj_cc.entity.UserProfile;
import com.example.softproj_cc.repository.UserRepository;
import com.example.softproj_cc.service.TokenService;
import com.example.softproj_cc.service.UserProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
public class UserProfileController {

    private final TokenService tokenService;
    private final UserRepository userRepository;
    private final UserProfileService userProfileService;

    public UserProfileController(TokenService tokenService,
                                 UserRepository userRepository,
                                 UserProfileService userProfileService) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
        this.userProfileService = userProfileService;
    }

    @PostMapping
    public ResponseEntity<UserProfile> createProfile(
            @RequestHeader(value = "Authorization", required = false) String authHeader,
            @RequestBody UserProfileRequest request
    ) {
        // 1) 헤더 확인
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        String token = authHeader.substring(7);

        // 2) 토큰 검증
        if (!tokenService.validateToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // 3) 토큰에서 username 추출
        String username = tokenService.getUsernameByToken(token);

        // 4) username → User → userId
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        Long userId = user.getId();

        // 5) 서비스 호출
        UserProfile created = userProfileService.createUserProfile(userId, request);
        return ResponseEntity.ok(created);
    }
}