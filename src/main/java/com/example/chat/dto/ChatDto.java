package com.example.chat.dto;

import com.example.chat.entity.ChatInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ChatDto {
    private Long chatNo;
    private String title;


    public static ChatDto fromEntity(ChatInfo entity){
        return ChatDto.builder()
                .chatNo(entity.getChatNo())
                .title(entity.getChatTitle())
                .build();
    }
}
