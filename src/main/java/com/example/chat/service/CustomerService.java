package com.example.chat.service;

import com.example.chat.dto.LoginRequestDto;
import com.example.chat.entity.Customer;
import com.example.chat.repo.CustomerRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Boolean login(LoginRequestDto dto, HttpSession session){
        Customer result = customerRepository.findCustomerByLoginIdAndAndCustPwd(dto.getUserId(),dto.getPassword());
        if(result != null){
            session.setMaxInactiveInterval(1800);
            session.setAttribute("custIdx",result.getCustIdx());
            session.setAttribute("loginId",result.getLoginId());
            session.setAttribute("custNm",result.getCustNm());
        }
        return result != null;
    }
}
