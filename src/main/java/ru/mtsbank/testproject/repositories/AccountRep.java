package ru.mtsbank.testproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mtsbank.testproject.data.Account;

import java.util.List;

@Repository
public interface AccountRep extends CrudRepository<Account, Long> {
    List<Account> findAll();
}
