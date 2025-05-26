package com.example.softproj_cc.dto;

import lombok.Data;

@Data
public class LikeRequest {
    private Long toUserId;
    private Long fromUserId;
}

