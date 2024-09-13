package com.anmol.banking_app.service.implementation;

import com.anmol.banking_app.dto.AccountDto;
import com.anmol.banking_app.entity.Account;
import com.anmol.banking_app.mapper.AccountMapper;
import com.anmol.banking_app.repository.AccountRepository;
import com.anmol.banking_app.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountImplementation implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = accountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return accountMapper.maptoAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
       Account account= accountRepository
               .findById(id).
               orElseThrow(()-> new RuntimeException("Account does not Exsist"));
        return accountMapper.maptoAccountDto(account);
    }

    @Override
    public AccountDto depositMoney(Long id,double money) {
        Account account = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not found"));
        account.setBalance(account.getBalance()+money);
        Account updatedAccount = accountRepository.save(account);
        return accountMapper.maptoAccountDto(updatedAccount);

    }

    @Override
    public AccountDto withdrawMoney(Long id, double money) {
        Account account = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not found"));
        if(account.getBalance()<money){
            throw new RuntimeException("Insufficient Balance");
        }
        account.setBalance(account.getBalance()-money);
        Account updatedAccount = accountRepository.save(account);
        return accountMapper.maptoAccountDto(updatedAccount);
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not found"));
         accountRepository.deleteById(id);
    }
}
