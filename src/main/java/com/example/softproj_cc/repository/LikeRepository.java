package com.example.softproj_cc.repository;

import com.example.softproj_cc.entity.Like;
import com.example.softproj_cc.entity.LikeId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, LikeId> {

    // senderId 기준 검색
    List<Like> findBySenderId(Long senderId);

    // senderId + receiverId 조합 존재 여부
    boolean existsBySenderIdAndReceiverId(Long senderId, Long receiverId);

    // Like 객체 검색
    Optional<Like> findBySenderIdAndReceiverId(Long senderId, Long receiverId);
}