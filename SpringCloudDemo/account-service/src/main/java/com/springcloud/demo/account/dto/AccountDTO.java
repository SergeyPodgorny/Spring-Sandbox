package com.springcloud.demo.account.dto;

import com.springcloud.demo.account.entity.Account;
import lombok.*;

import javax.persistence.ElementCollection;
import java.time.OffsetDateTime;
import java.util.List;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    private String name;

    private String email;

    private String phone;

    private OffsetDateTime creationDateTime;

    @ElementCollection
    private List<Long> bills;

    public AccountDTO(Account account) {
        this.name = account.getName();
        this.email = account.getEmail();
        this.phone = account.getPhone();
        this.creationDateTime = account.getCreationalDateTime();
        this.bills = account.getBills();
    }

}
