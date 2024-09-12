package com.example.chat.controller;

import com.example.chat.dto.MessageDto;
import com.example.chat.service.MessageService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MessageController {
    @Autowired
    private MessageService messageService;

    @MessageMapping("/{chatNo}") //여기로 전송되면 메서드 호출 -> WebSocketConfig prefixes 에서 적용한건 앞에 생략
    @SendTo("/chat/{chatNo}")   //구독하고 있는 장소로 메시지 전송 (목적지)  -> WebSocketConfig Broker 에서 적용한건 앞에 붙어줘야됨
    public ResponseEntity<MessageDto> send(@DestinationVariable Long chatNo, MessageDto dto){
        dto.setChatNo(chatNo);
        MessageDto result = messageService.send(dto);
        return ResponseEntity
                .ok()
                .body(result);
    }

}
