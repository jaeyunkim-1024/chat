package com.example.chat.controller;

import com.example.chat.dto.LoginRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "/home")
public class HomeController {
    @PostMapping("/login")
    public String login(LoginRequestDto dto) {
        return "login";
    }

    @PostMapping("/logout")
    public String logout() {
        return "logout";
    }
}
