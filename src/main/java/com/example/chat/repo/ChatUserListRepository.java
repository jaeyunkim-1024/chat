package com.example.chat.repo;

import com.example.chat.entity.ChatUserList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatUserListRepository extends JpaRepository<ChatUserList,Long> {
    ChatUserList findChatUserListByChatNo(Long chatNo);
}
