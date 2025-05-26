package com.example.softproj_cc.repository;

import com.example.softproj_cc.entity.User;
import com.example.softproj_cc.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    Optional<UserProfile> findByUser(User user);
}

