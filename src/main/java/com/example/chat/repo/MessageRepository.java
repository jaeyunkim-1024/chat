package com.example.chat.repo;

import com.example.chat.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Long> {
    List<Message> findMessageByChatNoOrderBySendAtDesc(Long chatNo);
}
