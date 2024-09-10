package com.example.chat.service;

import com.example.chat.dto.LoginRequestDto;
import com.example.chat.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Integer login(LoginRequestDto dto){
        Long result = customerRepository.countCustomersByLoginIdAndAndCustPwd(dto.getUserId(),dto.getPassword());
        return Integer.parseInt(result.toString());
    }
}
