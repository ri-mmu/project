package com.example.softproj_cc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

    public void createChatRoom(Long userAId, Long userBId) {
        // TODO: 실제 채팅방 생성 로직
        System.out.println("Creating chat room for users: " + userAId + " and " + userBId);
    }

    public void sendMessage(Long chatRoomId, Long senderId, String content) {
        // TODO: 실제 메시지 전송 로직
        System.out.println("Sending message to chat room " + chatRoomId + " from " + senderId + ": " + content);
    }
}