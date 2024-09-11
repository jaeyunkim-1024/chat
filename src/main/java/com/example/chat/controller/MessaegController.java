package com.example.chat.controller;

import com.example.chat.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MessaegController {
    @MessageMapping("/{chatNo}") //여기로 전송되면 메서드 호출 -> WebSocketConfig prefixes 에서 적용한건 앞에 생략
    @SendTo("/message/{chatNo}")   //구독하고 있는 장소로 메시지 전송 (목적지)  -> WebSocketConfig Broker 에서 적용한건 앞에 붙어줘야됨
    public ResponseEntity<MessageDto> send(@DestinationVariable Long chatNo, MessageDto dto){
        log.info("[kbug] message!!!!!!");
        return ResponseEntity
                .ok()
                .body(dto);
    }

}
