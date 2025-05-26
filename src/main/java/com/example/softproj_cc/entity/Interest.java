package com.example.softproj_cc.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;

    @Builder.Default
    @ManyToMany(mappedBy = "interests")
    private Set<UserProfile> userProfiles = new HashSet<>();
}