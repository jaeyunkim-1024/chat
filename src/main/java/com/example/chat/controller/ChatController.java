package com.example.chat.controller;

import com.example.chat.dto.ChatDto;
import com.example.chat.service.ChatInfoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/chat")
@Slf4j
public class ChatController {
    @Autowired
    ChatInfoService chatInfoService;

    @GetMapping("/list")
    public ResponseEntity<List<ChatDto>> chatList(){
        List<ChatDto> result = chatInfoService.getChatList();
        return ResponseEntity
                .ok(result);

    }

    @PostMapping("/join/{chatNo}")
    public ResponseEntity<Object> join(HttpServletRequest req, @PathVariable Long chatNo){
        try{
            HttpHeaders httpHeaders = new HttpHeaders();

            HttpSession session = req.getSession();
            String custIdxStr = session.getAttribute("custIdx").toString();
            chatInfoService.join(chatNo,Long.parseLong(custIdxStr));

            return ResponseEntity
                    .ok()
                    .headers(httpHeaders)
                    .body(true);

        }catch(Exception e){
            return ResponseEntity
                    .ok()
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/exit/{chatNo}")
    public ResponseEntity<String> exit(HttpServletRequest req, @PathVariable Long chatNo){
        HttpSession session = req.getSession();
        String custIdxStr = session.getAttribute("custIdx").toString();
        chatInfoService.join(chatNo,Long.parseLong(custIdxStr));


        return ResponseEntity
                .ok()
                .body("join");
    }
}