package com.tucandeira.mypiggy.account.domain.model;

public abstract class BankAccount {

    protected String agency;
    protected String accountNumber;
    protected String branchNumber;

    public BankAccount(String agency, String accountNumber, String branchNumber) {
        this.agency = agency;
        this.accountNumber = accountNumber;
        this.branchNumber = branchNumber;
    }

    public String getAgency() {
        return agency;
    }

    public String getBank() {
        return branchNumber; // ou algo como: return agency + "-" + branchNumber;
    }

    public abstract boolean withdraw(int quantityInCents);
}

