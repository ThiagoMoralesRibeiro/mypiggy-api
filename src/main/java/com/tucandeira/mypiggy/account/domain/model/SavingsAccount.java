package com.tucandeira.mypiggy.account.domain.model;

public class SavingsAccount extends BankAccount {

    private int withdrawsLimit;
    private int monthlyWithdraws;

    public SavingsAccount(String agency, String accountNumber, String branchNumber, int withdrawsLimit) {
        super(agency, accountNumber, branchNumber);
        this.withdrawsLimit = withdrawsLimit;
        this.monthlyWithdraws = 0;
    }

    @Override
    public boolean withdraw(int quantityInCents) {
        if (monthlyWithdraws >= withdrawsLimit) {
            return false;
        }
        monthlyWithdraws++;
        return true; // Implementar lógica de verificação de saldo real
    }

    public void resetMonthlyWithdraws() {
        this.monthlyWithdraws = 0;
    }
}

