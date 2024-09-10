package com.example.chat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "CHAT_USER_LIST")
@NoArgsConstructor
@AllArgsConstructor
public class ChatUserList {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "CHAT_USER_LIST_IDX")
    private Long chatUserListIdx;

    @Column(name = "CHAT_NO")
    private Long chatNo;

    @Column(name = "CUST_IDX_LIST")
    private String custIdxList;
}
