package com.example.chat.service;

import com.example.chat.dto.ChatDto;
import com.example.chat.entity.ChatInfo;
import com.example.chat.repo.ChatInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ChatInfoService {
    @Autowired
    private ChatInfoRepository chatInfoRepository;

    public List<ChatDto> getChatList(){
        List<ChatInfo> list = chatInfoRepository.findChatInfosByChatEnable("Y");
        return list.stream().map(ChatDto::fromEntity).toList();
    }
}
