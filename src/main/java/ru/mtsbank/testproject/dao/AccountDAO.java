package ru.mtsbank.testproject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;

@Component
public class AccountDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AccountDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer save(Integer accountCurrency, Integer clientId) {
        String insertSql = "INSERT INTO Account (ACCOUNT_CURRENCY, CLIENT_ID) VALUES (?, ?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(insertSql, new String[] { "ACCOUNT_NUMBER" });
            ps.setInt(1, accountCurrency);
            ps.setInt(2, clientId);
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public void deleteById(Integer id) {
        jdbcTemplate.update("DELETE FROM Account WHERE id=?", id);

    }
}
