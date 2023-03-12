package ru.mtsbank.testproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mtsbank.testproject.services.AccountService;

@RestController
@RequestMapping(value = "/accounts", produces = "application/json")
public class AccountsController {
    @Autowired
    private AccountService accountService;

    @PostMapping
    public Integer createAccount(@RequestParam("accountCurrency") Integer accountCurrency,
                              @RequestParam("clientId") Integer clientId) {
        return accountService.saveAccount(accountCurrency, clientId);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable("id") Integer id) {
        accountService.deleteAccount(id);
    }
}
