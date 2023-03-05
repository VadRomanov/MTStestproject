package ru.mtsbank.testproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mtsbank.testproject.data.Account;
import ru.mtsbank.testproject.data.Client;
import ru.mtsbank.testproject.services.ClientService;

import java.util.List;

@RestController
@RequestMapping(value = "/clients", produces = "application/json")
public class ClientsController {
    @Autowired
    private ClientService clientService;

    @PostMapping
    public Integer createClient(@RequestParam("lastName") String lastName,
                             @RequestParam("firstName") String firstName,
                             @RequestParam("patronymic") String patronymic,
                             @RequestParam("documentType") String documentType,
                             @RequestParam("seriesAndDocumentNumber") String seriesAndDocumentNumber,
                             @RequestParam("dateOfBirth") String dateOfBirth) {
        return clientService.saveClient(lastName, firstName, patronymic, documentType, seriesAndDocumentNumber, dateOfBirth);
    }

    @GetMapping
    public List<Client> getClients() {
        return clientService.getClients();
    }

    @GetMapping("/{id}")
    public List<Account> getAccountsOfClient(@PathVariable("id") Integer id) {
        return clientService.getAccountsOfClient(id);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable("id") Integer id) {
        clientService.deleteClient(id);
    }
}
