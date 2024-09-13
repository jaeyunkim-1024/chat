package com.example.chat.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "LOGIN_HISTORY")
@Getter
public class LoginHistory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "LOGIN_HISTORY_SEQ")
    private Long loginHistorySeq;

    // 사용자 INDEX
    @Column(name = "USER_SEQ")
    private Long userSeq;

    // 로그인 시간
    @Column(name = "LOGIN_AT")
    private Timestamp loginAt;
}
