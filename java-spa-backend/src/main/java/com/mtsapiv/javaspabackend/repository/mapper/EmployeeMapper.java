package com.mtsapiv.javaspabackend.repository.mapper;

import com.mtsapiv.javaspabackend.domain.Department;
import com.mtsapiv.javaspabackend.domain.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet row, int rowNum) throws SQLException {
        Employee employee = Employee.builder()
                .id(row.getLong("employee.id"))
                .isActive(row.getBoolean("employee.isActive"))
                .name(row.getString("employee.name"))
                .department(
                        Department.builder()
                        .name(row.getString("department.name"))
                        .id(row.getLong("department.id"))
                        .build())
                .build();
        return employee;
    }

}