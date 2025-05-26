package com.example.softproj_cc.controller;

import com.example.softproj_cc.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    @PostMapping("/create")
    public void createChatRoom(@RequestParam Long userAId, @RequestParam Long userBId) {
        chatRoomService.createChatRoom(userAId, userBId);
    }

    @PostMapping("/send")
    public void sendMessage(@RequestParam Long chatRoomId,
                            @RequestParam Long senderId,
                            @RequestParam String content) {
        chatRoomService.sendMessage(chatRoomId, senderId, content);
    }
}