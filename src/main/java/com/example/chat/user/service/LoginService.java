package com.example.chat.user.service;

import com.example.chat.user.dto.LoginRequestDto;
import com.example.chat.user.dto.UserDto;
import com.example.chat.user.entity.LoginHistory;
import com.example.chat.user.entity.User;
import com.example.chat.user.repository.LoginHistoryRepository;
import com.example.chat.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
@Slf4j
public class LoginService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginHistoryRepository loginHistoryRepository;

    public UserDto login(LoginRequestDto dto){
        User login = User.fromDto(dto);
        User result = userRepository.findUserByLoginIdAndPassword(login.getLoginId(),login.getPassword());
        loginHistory(result.getUserSeq());
        return UserDto.fromEntity(result);
    }

    @Async
    protected void loginHistory(Long userSeq){
        try{
            loginHistoryRepository.save(LoginHistory.builder()
                    .userSeq(userSeq)
                    .loginAt(Timestamp.valueOf(LocalDateTime.now()))
                    .build());
        }catch(Exception e){
            log.error(e.getMessage());
            e.fillInStackTrace();
        }
    }
}
