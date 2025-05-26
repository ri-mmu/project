package com.example.softproj_cc.entity;

import com.example.softproj_cc.entity.enums.LikeStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_likes")
@IdClass(LikeId.class)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Like {

    @Id
    @Column(name = "sender_id")
    private Long senderId;

    @Id
    @Column(name = "receiver_id")
    private Long receiverId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LikeStatus status;

    @Column(name = "sent_at", nullable = false)
    private LocalDateTime sentAt;

    @Column(name = "responded_at")
    private LocalDateTime respondedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("senderId")
    @JoinColumn(name = "sender_id", insertable = false, updatable = false)
    @ToString.Exclude
    private User sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("receiverId")
    @JoinColumn(name = "receiver_id", insertable = false, updatable = false)
    @ToString.Exclude
    private User receiver;
}

