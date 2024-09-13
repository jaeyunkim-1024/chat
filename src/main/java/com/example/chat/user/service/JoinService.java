package com.example.chat.user.service;


import com.example.chat.user.dto.UserDto;
import com.example.chat.user.dto.UserJoinRequestDto;
import com.example.chat.user.entity.User;
import com.example.chat.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JoinService {
    @Autowired
    private UserRepository userRepository;

    public UserDto join(UserJoinRequestDto dto){
        User user = userRepository.findUserByLoginId(dto.getLoginId());
        if(user == null){
            User newUser = User.fromDto(dto);
            return UserDto.fromEntity(userRepository.save(newUser));
        }
        return UserDto.fromEntity(user);
    }

    public void withDraw(UserJoinRequestDto dto){
        User user = userRepository.findUserByLoginId(dto.getLoginId());
        if(user != null){
            userRepository.delete(user);
        }
    }
}
