// RecommendationController.java
/* package com.example.softproj_cc.controller;

import com.example.softproj_cc.dto.RecommendationDto;
import com.example.softproj_cc.util.JwtUtil;
import com.example.softproj_cc.service.RecommendationService;
import com.example.softproj_cc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
@RequiredArgsConstructor
public class RecommendationController {
    private final JwtUtil jwtUtil;
    private final UserService userService;
    private final RecommendationService recommendationService;

    @GetMapping
    public ResponseEntity<?> getRecommendations(
            @RequestParam String token,
            @RequestParam String desiredMajor,
            @RequestParam(defaultValue = "5") int limit) {

        if (!jwtUtil.validateToken(token)) {
            return ResponseEntity.status(401).body("유효하지 않은 토큰입니다.");
        }
        var username = jwtUtil.extractUsername(token);
        var me = userService.findByUsername(username);

        List<RecommendationDto> recs = recommendationService
                .recommend(me.getId(), desiredMajor, limit);
        return ResponseEntity.ok(recs);
    }
}
 */
