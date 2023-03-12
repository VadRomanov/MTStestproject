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
import ru.mtsbank.testproject.services.AccountService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountsController.class)
class AccountsControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private AccountService accountService;

    @Test
    void createAccount() throws Exception {
        Integer id = 1;
        when(accountService.saveAccount(123, 1)).thenReturn(id);
        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/accounts").param("accountCurrency","123")
                .param("clientId","1")).andReturn();
        Integer resultId = Integer.valueOf(result.getResponse().getContentAsString());
        assertEquals(id, resultId);
        System.out.println();
    }
}