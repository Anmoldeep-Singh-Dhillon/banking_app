package com.anmol.banking_app.mapper;

import com.anmol.banking_app.dto.AccountDto;
import com.anmol.banking_app.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    Account mapToAccount(AccountDto accountDto);
    AccountDto maptoAccountDto(Account account);
}
