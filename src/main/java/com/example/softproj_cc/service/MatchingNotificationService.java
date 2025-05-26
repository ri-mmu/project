package com.example.softproj_cc.service;

import com.example.softproj_cc.entity.User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class MatchingNotificationService {

    public Map<String, List<String>> findUsersWhoMightBeInterested(User user) {
        // 테스트용 빈 map 반환
        return Collections.emptyMap();
    }
}