package com.example.softproj_cc.controller;

import com.example.softproj_cc.entity.ChatMessage;
import com.example.softproj_cc.entity.ChatRoom;


public class ApiResponse<T> {
    public static ApiResponse<ChatMessage> success(ChatMessage room) {
        return ApiResponse.success(room);
    }

    public static ApiResponse<ChatRoom> success(ChatRoom room) {
        return ApiResponse.success(room);
    }
}
