package ru.mtsbank.testproject.services;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mtsbank.testproject.config.PermissibleValuesConfig;
import ru.mtsbank.testproject.dao.AccountDAO;

@Service
public class AccountService {
    final static Logger logger = (Logger) LoggerFactory.getLogger("ru.mtsbank.testproject.services.AccountService");

    @Autowired
    private PermissibleValuesConfig permissibleValuesConfig;
    @Autowired
    private AccountDAO accountDAO;

    public Integer saveAccount(Integer accountCurrency, Integer clientId) {

        for (Integer currency : permissibleValuesConfig.getCurrency()) {
            if (accountCurrency.equals(currency)) {
                return accountDAO.save(accountCurrency, clientId);
            }
        }
        logger.error(accountCurrency + " currency is not supported");
        return null;
    }

    public void deleteAccount(Integer id) {
        accountDAO.deleteById(id);
    }
}
