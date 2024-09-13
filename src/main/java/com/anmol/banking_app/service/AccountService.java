package com.anmol.banking_app.service;

import com.anmol.banking_app.dto.AccountDto;
import com.anmol.banking_app.entity.Account;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id);
    AccountDto depositMoney(Long id,double money);
    AccountDto withdrawMoney(Long id,double money);
    void deleteAccount(Long id);

}
