package com.springcloud.demo.account.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private OffsetDateTime creationalDateTime;

    @ElementCollection
    private List<Long> bills;


    public Account(String name, String email, String phone, List<Long> bills) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.bills = bills;
    }
}
