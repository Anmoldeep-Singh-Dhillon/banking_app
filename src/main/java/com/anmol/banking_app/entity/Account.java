package com.anmol.banking_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.sql.exec.spi.StandardEntityInstanceResolver;

@Table(name = "accounts")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment id
    private Long id;

    @Column(name = "account_holder_name")
    private String accountHolderName;
    private double balance;
}
