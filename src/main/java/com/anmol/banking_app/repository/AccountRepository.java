package com.anmol.banking_app.repository;

import com.anmol.banking_app.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

//here we pass 2 things one is entity and other is data type of our id
public interface AccountRepository extends JpaRepository<Account,Long> {
}
