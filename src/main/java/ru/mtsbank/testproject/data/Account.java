package ru.mtsbank.testproject.data;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "ACCOUNTS")
public class Account {

    @Id
    private Long accountNumber;
    @NotNull
    private Integer accountCurrency;
    @NotNull
    private Integer clientId;

    public Account(Integer accountCurrency, Integer clientId) {
        this.accountCurrency = accountCurrency;
        this.clientId = clientId;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
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
