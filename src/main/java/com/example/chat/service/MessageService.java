package com.example.chat.service;

import com.example.chat.dto.MessageDto;
import com.example.chat.entity.Message;
import com.example.chat.repo.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageDto send(MessageDto dto){
        Message result = messageRepository.save(Message.toEntity(dto));
        return MessageDto.fromEntity(result);
    }

    public List<MessageDto> list(Long chatNo){
        List<Message> list = messageRepository.findMessageByChatNoOrderBySendAtDesc(chatNo);
        return list.stream().map(MessageDto::fromEntity).toList();
    }
}
