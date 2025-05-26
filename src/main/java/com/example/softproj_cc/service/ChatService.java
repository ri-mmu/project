// src/main/java/com/example/softproj_cc/service/ChatService.java

import com.example.softproj_cc.entity.ChatMessage;
import com.example.softproj_cc.entity.ChatRoom;
import com.example.softproj_cc.entity.User;
import com.example.softproj_cc.repository.ChatMessageRepository;
import com.example.softproj_cc.repository.ChatRoomRepository;
import com.example.softproj_cc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRoomRepository chatRoomRepository;
    private final UserRepository userRepository;
    private final ChatMessageRepository chatMessageRepository;

    public ChatMessage sendMessage(Long roomId, Long senderId, String content) {
        ChatRoom room = chatRoomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("ChatRoom not found: " + roomId));
        User sender = userRepository.findById(senderId)
                .orElseThrow(() -> new RuntimeException("Sender not found: " + senderId));

        ChatMessage message = ChatMessage.builder()
                .chatRoom(room)
                .sender(sender)
                .content(content)
                .sentAt(LocalDateTime.now())
                .build();

        return chatMessageRepository.save(message);
    }
}