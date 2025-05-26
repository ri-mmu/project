package com.example.softproj_cc.entity;
import java.io.Serializable;
import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikeId implements Serializable {
    private Long senderId;
    private Long receiverId;
}
