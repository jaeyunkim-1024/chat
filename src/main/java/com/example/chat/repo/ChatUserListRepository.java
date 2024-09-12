package com.example.chat.repo;

import com.example.chat.entity.ChatUserList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface ChatUserListRepository extends JpaRepository<ChatUserList,Long> {
    List<ChatUserList> findChatUserListsByChatNo(Long chatNo);

    int countChatUserListByChatNoAndJoinAtBetween(Long chatNo, Timestamp timestampLastMilliSec, Timestamp currentTime);
}
