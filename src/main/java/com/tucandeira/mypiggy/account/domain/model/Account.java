package com.tucandeira.mypiggy.account.domain.model;

import java.util.UUID;

import com.tucandeira.mypiggy.user.domain.model.User;

public class Account {
    private UUID id;
    private User holder;
    private int balanceInCents;
    private BankAccount bankAccount;

    public Account(User holder, BankAccount bankAccount) {
        this.holder = holder;
        this.bankAccount = bankAccount;
        this.balanceInCents = 0;
    }

    public boolean withdraw(int quantityInCents) {
        return bankAccount.withdraw(quantityInCents);
    }
}
