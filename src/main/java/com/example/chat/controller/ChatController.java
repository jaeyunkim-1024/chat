package com.example.chat.controller;

import com.example.chat.dto.ChatDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/chat")
@Slf4j
public class ChatController {
    @GetMapping("/list")
    public ResponseEntity<List<ChatDto>> chatList(){
        List<ChatDto> result = new ArrayList<ChatDto>();
        return ResponseEntity
                .ok(result);

    }

    @GetMapping("/join/{chatNo}")
    public ResponseEntity<String> join(@PathVariable int chatNo){
        HttpHeaders httpHeaders = new HttpHeaders();

        return ResponseEntity
                .ok()
                .headers(httpHeaders)
                .body("join");
    }
}