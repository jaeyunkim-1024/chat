package com.example.chat.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MessageDto {
    private Long custIdx;
    private Long chatNo;
    private String message;
}
