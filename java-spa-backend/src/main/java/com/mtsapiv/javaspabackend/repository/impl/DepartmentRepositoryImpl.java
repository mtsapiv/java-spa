package com.mtsapiv.javaspabackend.repository.impl;

import com.mtsapiv.javaspabackend.domain.Department;
import com.mtsapiv.javaspabackend.repository.DepartmentRepository;
import com.mtsapiv.javaspabackend.repository.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;

@Transactional
@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DepartmentRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Department department) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        final String  sql = "INSERT INTO department (name) values (?)";
        String id = "id";
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(sql, new String[]{id});
            ps.setString(1, department.getName());
            return ps;
        }, keyHolder );


        return Objects.requireNonNull(keyHolder.getKey()).intValue();
    }

    @Override
    public int update(Department department) {
        String sql = "UPDATE department SET name=? WHERE id=?";
        return jdbcTemplate.update(sql, department.getName(),  department.getId());
    }

    @Override
    public int delete(Long id) {
        String sql = "DELETE FROM department WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Department getOne(Long id) {
        String sql = "SELECT * FROM department WHERE id = ?";
        RowMapper<Department> rowMapper = new DepartmentMapper();
        Department department = jdbcTemplate.queryForObject(sql, rowMapper, id);
        return department;
    }

    @Override
    public List<Department> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        String sql = "SELECT * from department LIMIT ? OFFSET ?";
        RowMapper<Department> rowMapper = new DepartmentMapper();

        List<Department> departments = jdbcTemplate.query(sql, rowMapper, pageable.getPageSize(), pageable.getOffset());
        return departments;
    }
}
