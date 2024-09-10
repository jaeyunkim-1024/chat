package com.example.chat.controller;

import com.example.chat.dto.LoginRequestDto;
import com.example.chat.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "/home")
public class HomeController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(LoginRequestDto dto) {
        return ResponseEntity
                .ok()
                .body(Integer.compare(customerService.login(dto),1) == 0);
    }

    @PostMapping("/logout")
    public String logout() {
        return "logout";
    }
}
