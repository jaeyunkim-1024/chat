package com.example.chat.service;

import com.example.chat.dto.MessageDto;
import com.example.chat.entity.Message;
import com.example.chat.repo.MessageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class MessageServiceTest {
    @Autowired
    private MessageRepository messageRepository;

    @Test
    void send() {
        MessageDto dto = MessageDto.builder()
                .chatNo(1L)
                .custIdx(1L)
                .msg("메세지 왔어요")
                .build();
        final Message entity = Message.toEntity(dto);
        Message result = messageRepository.save(entity);
        assertEquals(1L,result.getMessageSeq());
    }

    @Test
    void list() {
        MessageDto dto = MessageDto.builder()
                .chatNo(1L)
                .custIdx(1L)
                .msg("메세지 왔어요")
                .build();
        final Message entity = Message.toEntity(dto);
        Message result = messageRepository.save(entity);

        final List<Message> list = messageRepository.findMessageByChatNoOrderBySendAtDesc(1L);
        assertEquals(result.getMsg(),list.get(0).getMsg());
    }
}