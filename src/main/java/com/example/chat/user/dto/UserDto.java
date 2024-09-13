package com.example.chat.user.dto;

import com.example.chat.user.entity.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private Long userSeq;
    private String loginId;
    private String userName;

    public static UserDto fromEntity(User entity){
        return UserDto.builder()
                .userSeq(entity.getUserSeq())
                .loginId(entity.getLoginId())
                .userName(entity.getUserName())
                .build();
    }
}
