package com.example.softproj_cc.controller;

import com.example.softproj_cc.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/likes")
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/respond")
    public ResponseEntity<String> respondLike(
            @RequestParam Long senderId,
            @RequestParam Long receiverId,
            @RequestParam String response
    ) {
        likeService.respondLike(senderId, receiverId, response);
        return ResponseEntity.ok("좋아요 응답 성공");
    }
}