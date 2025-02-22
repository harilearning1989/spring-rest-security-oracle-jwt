package com.web.demo.services;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DatabaseUtilService {

    private final JdbcTemplate jdbcTemplate;

    public DatabaseUtilService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> getColumnNamesForConstraint(String constraintName) {
        String sql = "SELECT column_name FROM all_cons_columns WHERE constraint_name = ?";
        return jdbcTemplate.queryForList(sql, String.class, constraintName);
    }
}

