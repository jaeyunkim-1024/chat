package com.example.chat.service;

import com.example.chat.dto.MessageDto;
import com.example.chat.entity.Message;
import com.example.chat.repo.ChatUserListRepository;
import com.example.chat.repo.MessageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class ChatUserListRepositoryTest {
    @Autowired
    private ChatUserListRepository chatUserListRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Test
    void getUserListWhen() {
        int milliSec = 30 * 60 * 1000;
        Long chatNo = 1L;

        MessageDto dto = MessageDto.builder()
                .chatNo(1L)
                .custIdx(1L)
                .msg("메세지 왔어요")
                .build();
        final Message entity = Message.toEntity(dto);
        messageRepository.save(entity);

        Timestamp currentTime = Timestamp.valueOf(LocalDateTime.now());
        // 매개변수로 받은 millisec을 분 단위로 변환
        long minutes = milliSec / (1000 * 60);
        // 현재 시간에서 해당 분 만큼 이전 시간 구하기
        LocalDateTime timeBefore = LocalDateTime.now().minusMinutes(minutes);
        Timestamp timestampLastMilliSec = Timestamp.valueOf(timeBefore);

        int result =  chatUserListRepository.countChatUserListByChatNoAndJoinAtBetween(chatNo,timestampLastMilliSec,currentTime);
        assertEquals(1,result);
    }
}