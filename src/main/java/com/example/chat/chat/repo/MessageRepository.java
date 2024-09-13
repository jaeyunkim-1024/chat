package com.example.chat.chat.repo;

import com.example.chat.chat.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Long> {
    List<Message> findMessageByChatNoOrderBySendAtDesc(Long chatNo);
}
