package ru.mtsbank.testproject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import ru.mtsbank.testproject.data.Account;
import ru.mtsbank.testproject.data.Client;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

@Component
public class ClientDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer save(String lastName, String firstName, String patronymic, String documentType,
                        String seriesAndDocumentNumber, Date dateOfBirth) {
        String insertSql = "INSERT INTO Client (LAST_NAME, FIRST_NAME, PATRONYMIC, DOCUMENT_TYPE, SERIES_AND_DOCUMENT_NUMBER, " +
                "DATE_OF_BIRTH) VALUES (?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(insertSql, new String[] { "ID" });
            ps.setString(1, lastName);
            ps.setString(2, firstName);
            ps.setString(3, patronymic);
            ps.setString(4, documentType);
            ps.setString(5, seriesAndDocumentNumber);
            ps.setDate(6, dateOfBirth);
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public List<Client> findAll() {
        List<Client> clients = jdbcTemplate.query("SELECT * FROM Client", new BeanPropertyRowMapper<>(Client.class));
        for (Client client: clients) {
            client.setAccounts(jdbcTemplate.query("SELECT * FROM Account WHERE CLIENT_ID=?", new BeanPropertyRowMapper<>(Account.class), client.getId()));
        }
        return clients;
    }

    public List<Account> findAccsById(Integer id) {
        return jdbcTemplate.query("SELECT * FROM Account WHERE CLIENT_ID=?", new BeanPropertyRowMapper<>(Account.class), id);
    }

    public void deleteById(Integer id) {
        jdbcTemplate.update("DELETE FROM Client WHERE id=?", id);
    }
}
