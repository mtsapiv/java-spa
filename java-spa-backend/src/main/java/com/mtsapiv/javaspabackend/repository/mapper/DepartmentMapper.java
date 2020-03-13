package com.mtsapiv.javaspabackend.repository.mapper;

import com.mtsapiv.javaspabackend.domain.Department;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentMapper implements RowMapper<Department> {

    @Override
    public Department mapRow(ResultSet row, int i) throws SQLException {

        Department department = Department.builder()
                .id(row.getLong("id"))
                .name(row.getString("name"))
                .build();
        return department;
    }
}
