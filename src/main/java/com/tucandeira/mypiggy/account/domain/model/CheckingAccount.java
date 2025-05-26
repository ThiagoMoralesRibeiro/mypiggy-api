package com.tucandeira.mypiggy.account.domain.model;

public class CheckingAccount extends BankAccount {

    private int creditLimitInCents;

    public CheckingAccount(String agency, String accountNumber, String branchNumber, int creditLimitInCents) {
        super(agency, accountNumber, branchNumber);
        this.creditLimitInCents = creditLimitInCents;
    }

    @Override
    public boolean withdraw(int quantityInCents) {
        // Implementar lógica de saque com base no crédito disponível
        // Exemplo simplificado:
        return quantityInCents <= creditLimitInCents;
    }

    public int getCreditLimitInCents() {
        return creditLimitInCents;
    }
}

