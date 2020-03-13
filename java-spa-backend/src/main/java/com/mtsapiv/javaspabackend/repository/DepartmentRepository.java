package com.mtsapiv.javaspabackend.repository;

import com.mtsapiv.javaspabackend.domain.Department;

import java.util.List;

public interface DepartmentRepository {

    int save(Department department);
    int update(Department Department);
    int delete(Long id);
    Department getOne(Long id);
    List<Department> findAll(int page, int size);
}
