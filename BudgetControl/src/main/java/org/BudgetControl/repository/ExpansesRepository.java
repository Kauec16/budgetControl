package org.BudgetControl.repository;

import ch.qos.logback.core.net.server.Client;
import org.BudgetControl.model.Expanses;
import org.BudgetControl.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ExpansesRepository {

    private JdbcTemplate jdbcTemplate;
    private String SELECT_ALL;

    private int id;
    private double value;
    private int primaryGuid;
    private String description;

    public List<Expanses> getAll(){
        return jdbcTemplate.query(SELECT_ALL, new RowMapper<Expanses>() {
            @Override
            public Expanses mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Expanses(rs.getInt("ID"),
                                    rs.getString("DESCRIPTION"),
                                    rs.getDouble("PRICE"));
            }
        });
    }


}
