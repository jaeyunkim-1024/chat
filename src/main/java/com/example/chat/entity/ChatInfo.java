package com.example.chat.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "CHAT_INFO")
public class ChatInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "CHAT_NO")
    private Long chatNo;

    @Column(name = "ADMIN_IDX")
    private Long adminIdx;

    @Column(name = "CHAT_TITLE")
    private String chatTitle;

    @Column(name = "CHAT_ENABLE")
    private String chatEnable;
}
