package org.BudgetControl.repository;

import org.BudgetControl.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private static String INSERT = "insert into cliente (nome, password) values (?, ?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User save(User client){
        jdbcTemplate.update(INSERT, new Object[]{client.getUsername(), client.getPassword()} );
    return client;
    }
}
