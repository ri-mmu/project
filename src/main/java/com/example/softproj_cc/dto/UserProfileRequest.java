package com.example.softproj_cc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileRequest {
    private String nickname;
    private Integer age;
    private String bio;
    private String major;
    private String photoUrl;

    private String gender;      // "MALE", "FEMALE" 과 같이 Gender enum 이름과 일치
    private Boolean isActive;   // 활성화 여부

    // 필요하다면 interests, introduction 등 다른 필드도 추가
}
