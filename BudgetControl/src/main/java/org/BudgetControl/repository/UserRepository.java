package org.BudgetControl.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import org.BudgetControl.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRepository {

    private static String INSERT = "insert into cliente (nome, password) values (?, ?)";

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public User save(User user){
        entityManager.persist(user);
    return user;
    }

    @Transactional
    private  User update(User user){
        entityManager.merge(user);
        return user;
    }

}
