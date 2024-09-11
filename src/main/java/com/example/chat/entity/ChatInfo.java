package com.example.chat.entity;

import com.example.chat.dto.ChatDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "CHAT_INFO")
@AllArgsConstructor
@NoArgsConstructor
public class ChatInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "CHAT_NO")
//    @SequenceGenerator(name = "chat_info_seq_gen", sequenceName = "CHAT_NO", allocationSize = 1)
    private Long chatNo;

    @Column(name = "ADMIN_IDX")
    private Long adminIdx;

    @Column(name = "CHAT_TITLE")
    private String chatTitle;

    @Column(name = "CHAT_ENABLE")
    private String chatEnable;

    public static ChatInfo toEntity(ChatDto dto,Long custIdx){
        return new ChatInfo(
                null,
                custIdx,
                dto.getTitle(),
                "Y"
        );
    }
}
