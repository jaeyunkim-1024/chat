package com.example.chat.repo;

import com.example.chat.entity.ChatInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatInfoRepository extends JpaRepository <ChatInfo,Long> {
    List<ChatInfo> findChatInfosByChatEnable(String chatEnable);

    ChatInfo findChatInfoByChatNoAndChatEnable(Long chatNo, String chatEnable);
}
