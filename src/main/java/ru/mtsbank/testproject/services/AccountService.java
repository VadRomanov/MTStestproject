package ru.mtsbank.testproject.services;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mtsbank.testproject.config.PermissibleValuesConfig;
import ru.mtsbank.testproject.data.Account;
import ru.mtsbank.testproject.repositories.AccountRep;

@Service
public class AccountService {
    final static Logger logger = (Logger) LoggerFactory.getLogger("ru.mtsbank.testproject.services.AccountService");

    @Autowired
    private PermissibleValuesConfig permissibleValuesConfig;
    @Autowired
    private AccountRep accountRep;

    public Long saveAccount(Integer accountCurrency, Integer clientId) {
        for (Integer currency : permissibleValuesConfig.getCurrency()) {
            if (accountCurrency.equals(currency)) {
                return accountRep.save(new Account(accountCurrency, clientId)).getAccountNumber();
            }
        }
        logger.error(accountCurrency + " currency is not supported");
        return null;
    }

    public void deleteAccount(Long id) {
        accountRep.deleteById(id);
    }
}
