package com.example.chat.repo;

import com.example.chat.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    public long countCustomersByLoginIdAndAndCustPwd(String loginId, String custPwd);
}
