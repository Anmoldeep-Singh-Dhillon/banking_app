package com.anmol.banking_app.controller;

import com.anmol.banking_app.dto.AccountDto;
import com.anmol.banking_app.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/add")
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return  new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/deposit/{id}")
    public ResponseEntity<AccountDto>  deposit(@PathVariable Long id, @RequestBody Map<String,Double> request){
        AccountDto accountDto = accountService.depositMoney(id,request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/withdraw/{id}")
    public ResponseEntity<AccountDto>  withdraw(@PathVariable Long id, @RequestBody Map<String,Double> request){
        AccountDto accountDto = accountService.withdrawMoney(id,request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account: {} deleted successfully");
    }

}
