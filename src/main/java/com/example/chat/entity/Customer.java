package com.example.chat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "CUST_IDX")
    private Long custIdx;

    @Column(name = "LOGIN_ID")
    private String loginId;

    @Column(name = "CUST_PWD")
    private String custPwd;

    @Column(name = "CUST_NM")
    private String custNm;
}
