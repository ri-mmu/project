package com.example.softproj_cc.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatchId implements Serializable {
    private Long userA;
    private Long userB;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MatchId)) return false;
        MatchId matchId = (MatchId) o;
        return Objects.equals(userA, matchId.userA) &&
                Objects.equals(userB, matchId.userB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userA, userB);
    }
}