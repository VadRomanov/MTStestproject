package ru.mtsbank.testproject.controllers;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.mtsbank.testproject.services.AccountService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountsController.class)
class AccountsControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private AccountService accountService;

    @Test
    void createAccount() throws Exception {
        Long id = 1L;
        when(accountService.saveAccount(123, 1)).thenReturn(id);
        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/accounts").param("accountCurrency","123")
                .param("clientId","1")).andReturn();
        Long resultId = Long.valueOf(result.getResponse().getContentAsString());
        assertEquals(id, resultId);
        System.out.println();
    }
}