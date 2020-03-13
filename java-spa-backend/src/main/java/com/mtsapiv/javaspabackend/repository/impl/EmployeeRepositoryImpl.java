package com.mtsapiv.javaspabackend.repository.impl;

import com.mtsapiv.javaspabackend.domain.Employee;
import com.mtsapiv.javaspabackend.repository.EmployeeRepository;
import com.mtsapiv.javaspabackend.repository.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;

@Repository
@Transactional
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Long save(Employee employee) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        final String  sql = "INSERT INTO employee (name, isActive, departmentId) values (?, ?, ?)";
        String id = "id";
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(sql, new String[]{id});
            ps.setString(1, employee.getName());
            ps.setBoolean(2, employee.isActive());
            ps.setLong(3, employee.getDepartment().getId());
            return ps;
        }, keyHolder );


        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    @Override
    public int update(Employee employee) {
        String sql = "UPDATE employee SET name=?, isActive=?, departmentId=? WHERE id=?";
        return jdbcTemplate.update(sql, employee.getName(), employee.isActive(), employee.getDepartment().getId(), employee.getId());
    }

    @Override
    public int delete(Long id) {
        String sql = "DELETE FROM employee WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Employee getOne(Long id) {
        String sql = "SELECT employee.name, employee.id, employee.isActive, department.name, department.id FROM employee" +
                "  LEFT JOIN  department ON" +
                " employee.departmentId = department.id" +
                " WHERE employee.id = ?";
        RowMapper<Employee> rowMapper = new EmployeeMapper();
        Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, id);
        return employee;
    }

    @Override
    public List<Employee> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        String sql = "SELECT * from employee " +
                "  LEFT JOIN  department ON" +
                " employee.departmentId = department.id" +
                " LIMIT ? OFFSET ? ";
        RowMapper<Employee> rowMapper = new EmployeeMapper();

        List<Employee> employees = jdbcTemplate.query(sql, rowMapper, pageable.getPageSize(), pageable.getOffset());
        return employees;
    }

    @Override
    public List<Employee> findByName(int page, int size, String startWith) {
        Pageable pageable = PageRequest.of(page, size);

        String sql = "SELECT * from employee" +
                " LEFT JOIN  department " +
                " ON employee.departmentId = department.id " +
                " WHERE employee.name LIKE ? " +
                " LIMIT ? OFFSET ? ";

        RowMapper<Employee> rowMapper = new EmployeeMapper();

        List<Employee> employees = jdbcTemplate.query(sql, rowMapper, startWith+"%", pageable.getPageSize(), pageable.getOffset());
        return employees;
    }

}

