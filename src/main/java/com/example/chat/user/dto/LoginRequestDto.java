package com.example.chat.user.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class LoginRequestDto {
    private String loginId;
    private String password;
    private String userName;
    private Timestamp loginAt;
}
