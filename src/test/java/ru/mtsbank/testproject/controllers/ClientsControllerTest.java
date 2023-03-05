package ru.mtsbank.testproject.controllers;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.mtsbank.testproject.data.Account;
import ru.mtsbank.testproject.data.Client;
import ru.mtsbank.testproject.services.ClientService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(ClientsController.class)
class ClientsControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private ClientService clientService;

    @Test
    void createClient() throws Exception {
        Integer id = 1;
        when(clientService.saveClient("", "", "", "",
                "", "")).thenReturn(id);
        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/clients").param("lastName","")
                .param("firstName","").param("patronymic", "").param("documentType", "")
                .param("seriesAndDocumentNumber", "").param("dateOfBirth", "")).andReturn();
        Integer resultId = Integer.valueOf(result.getResponse().getContentAsString());
        assertEquals(id, resultId);
    }

    @Test
    void getClients() throws Exception {
        String resultClientsAsString = "[{\"id\":null,\"lastName\":\"lastName\",\"firstName\":\"firstName\"," +
                "\"patronymic\":\"patronymic\",\"documentType\":\"passport\",\"seriesAndDocumentNumber\":\"123456789\"," +
                "\"dateOfBirth\":\"1970-01-01\",\"accounts\":null},{\"id\":null,\"lastName\":\"Name\"," +
                "\"firstName\":\"Surname\",\"patronymic\":\"Patronymic\",\"documentType\":\"passport\"," +
                "\"seriesAndDocumentNumber\":\"456789\",\"dateOfBirth\":\"1970-01-01\",\"accounts\":null}]";
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("lastName", "firstName", "patronymic", "passport",
                "123456789", new Date(1970-01-01)));
        clients.add(new Client("Name", "Surname", "Patronymic", "passport",
                "456789", new Date(1970-01-01)));
        when(clientService.getClients()).thenReturn(clients);
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/clients")).andReturn();
        String resultClient = result.getResponse().getContentAsString();
        assertEquals(resultClientsAsString, resultClient);
    }

    @Test
    void getAccountsOfClient() throws Exception {
        Integer id = 1;
        String resultAccountsAsString = "[{\"accountNumber\":null,\"accountCurrency\":123,\"clientId\":" + id + "}," +
                "{\"accountNumber\":null,\"accountCurrency\":321,\"clientId\":" + id + "}]";
        Client client = new Client("", "", "", "",
                "", new Date(1970-01-01));
        client.setId(id);
        client.setAccounts(List.of(new Account(123, id), new Account(321, id)));
        when(clientService.getAccountsOfClient(id)).thenReturn(client.getAccounts());
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/clients/" + id)).andReturn();
        String resultAccounts = result.getResponse().getContentAsString();
        assertEquals(resultAccountsAsString, resultAccounts);
    }
}