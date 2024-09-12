package com.example.chat.entity;

import com.example.chat.dto.ChatDto;
import com.example.chat.dto.MessageDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MESSAGE")
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "MESSAGE_SEQ")
    private Long messageSeq;

    @Column(name = "CUST_IDX")
    private Long custIdx;

    @Column(name = "CHAT_NO")
    private Long chatNo;

    @Column(name = "MSG")
    private String msg;

    @Column(name = "SEND_AT")
    private Timestamp sendAt;

    public static Message toEntity(MessageDto dto){
        return new Message(
                null,
                dto.getCustIdx(),
                dto.getChatNo(),
                dto.getMsg(),
                Timestamp.valueOf(LocalDateTime.now())
        );
    }
}
