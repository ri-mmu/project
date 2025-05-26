package com.example.softproj_cc.dto;

import lombok.Data;

import java.util.Set;

@Data
public class ChatRoomRequest { private Set<Long> participantIds; }

