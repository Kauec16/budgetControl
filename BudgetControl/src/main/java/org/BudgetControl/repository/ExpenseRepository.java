package org.BudgetControl.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.BudgetControl.model.Expense;
import org.BudgetControl.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ExpenseRepository {


    @Autowired
    private EntityManager entityManager;

    private String SELECT_ALL;

    private int id;
    private double value;
    private int primaryGuid;
    private String description;


    @Transactional
    public Expense getById(int id){
        Expense expanses = entityManager.find(Expense.class, id);
        return expanses;
    }

    @Transactional
    public List<Expense> list(Expense expanse){
        String jpql = "select c from Expanses c";
        TypedQuery<Expense> query = entityManager.createQuery(jpql, Expense.class);
        return query.getResultList();
    }

    @Transactional
    public void delete(Expense expanse){
        if(entityManager.contains(expanse)){
            entityManager.merge(expanse);
        }
        entityManager.remove(expanse);
    }


}
