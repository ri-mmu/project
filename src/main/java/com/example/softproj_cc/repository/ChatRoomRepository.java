package com.example.softproj_cc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.softproj_cc.entity.ChatRoom;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
}
