package com.example.chat.controller;

import com.example.chat.dto.LoginRequestDto;
import com.example.chat.service.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
    public ResponseEntity<Boolean> login(HttpServletRequest req, LoginRequestDto dto) {
        boolean isLogin = customerService.login(dto,req.getSession());
        return ResponseEntity
                .ok()
                .body(isLogin);
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if(session != null){
            session.removeAttribute("custNm");
            session.removeAttribute("loginId");
            session.removeAttribute("custIdx");
        }
        return "logout";
    }
}
