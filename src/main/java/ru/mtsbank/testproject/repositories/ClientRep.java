package ru.mtsbank.testproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mtsbank.testproject.data.Client;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRep extends CrudRepository<Client, Integer> {
    List<Client> findAll();

    Optional<Client> findById(Integer id);
}
