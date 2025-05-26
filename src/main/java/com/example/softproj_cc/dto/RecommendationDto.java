package com.example.softproj_cc.dto;

import lombok.Data;

import java.util.List;

@Data
public class RecommendationDto {
    private String username;
    private String nickname;
    private String photoUrl;
    private List<String> interests;
}
