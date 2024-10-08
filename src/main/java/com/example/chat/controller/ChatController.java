package com.example.chat.controller;

import com.example.chat.dto.ChatDto;
import com.example.chat.dto.MessageDto;
import com.example.chat.service.ChatInfoService;
import com.example.chat.service.MessageService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
@Slf4j
public class ChatController {
    @Autowired
    private ChatInfoService chatInfoService;

    @Autowired
    private MessageService messageService;

    @GetMapping("/list")
    public ResponseEntity<List<ChatDto>> chatList(){
        List<ChatDto> result = chatInfoService.getChatList();
        return ResponseEntity
                .ok(result);
    }

    @PostMapping("/create")
    public ResponseEntity<ChatDto> create(HttpServletRequest req, ChatDto dto){
        HttpSession session = req.getSession();
        String custIdxStr = session.getAttribute("custIdx").toString();
        ChatDto result = chatInfoService.create(dto,Long.parseLong(custIdxStr));
        return ResponseEntity
                .ok(result);
    }

    @PostMapping("/join/{chatNo}")
    public ResponseEntity join(HttpServletRequest req, @PathVariable Long chatNo){
        try{
            HttpSession session = req.getSession();
            String custIdxStr = session.getAttribute("custIdx").toString();
            chatInfoService.join(chatNo,Long.parseLong(custIdxStr));

            /// 채팅 토큰
            /// 채팅방 번호 담음
            /// 혹은, 채팅방에 접근할 수 있는지 없는지 등등
            HttpHeaders headers = new HttpHeaders();
            headers.set("joinChatNo",chatNo.toString());
            headers.set("isForbidden","N");

            return ResponseEntity
                    .ok()
                    .headers(headers)
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
        chatInfoService.exit(chatNo,Long.parseLong(custIdxStr));

        return ResponseEntity
                .ok()
                .body("join");
    }

    @GetMapping("/message/{chatNo}")
    public ResponseEntity<List<MessageDto>> messageList(@PathVariable Long chatNo){
        return ResponseEntity
                .ok()
                .body(messageService.list(chatNo));
    }

    @GetMapping("/viewer/{chatNo}")
    public ResponseEntity<Integer> getViewers(@PathVariable Long chatNo){
        return ResponseEntity
                .ok()
                .body(chatInfoService.getChatViewerWhenLast(chatNo,30 * 60 * 1000));
    }

}