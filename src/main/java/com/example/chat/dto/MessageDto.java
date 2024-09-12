package com.example.chat.dto;

import com.example.chat.entity.Message;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MessageDto {
    private Long custIdx;
    private Long chatNo;
    private String msg;

    public String toString(){
        return "MessageDto{custIdx:" + custIdx + ", chatNo:" + chatNo + ", msg:" + msg + "}";
    }

    public static MessageDto fromEntity(Message entity){
        return MessageDto
                .builder()
                .custIdx(entity.getCustIdx())
                .chatNo(entity.getChatNo())
                .msg(entity.getMsg())
                .build();
    }
}
