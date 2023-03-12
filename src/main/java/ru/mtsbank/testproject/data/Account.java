package ru.mtsbank.testproject.data;

import jakarta.validation.constraints.NotNull;

public class Account {

    private Integer accountNumber;
    @NotNull
    private Integer accountCurrency;
    @NotNull
    private Integer clientId;

    public Account() {
    }

    public Account(Integer accountCurrency, Integer clientId) {
        this.accountCurrency = accountCurrency;
        this.clientId = clientId;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(Integer accountCurrency) {
        this.accountCurrency = accountCurrency;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", accountCurrency='" + accountCurrency + '\'' +
                ", clientId=" + clientId +
                '}';
    }
}
