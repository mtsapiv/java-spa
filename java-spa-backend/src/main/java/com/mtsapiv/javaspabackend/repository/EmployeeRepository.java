package com.mtsapiv.javaspabackend.repository;

import com.mtsapiv.javaspabackend.domain.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeRepository {

    Long save(Employee employee);
    int update(Employee employee);
    int delete(Long id);
    Employee getOne(Long id);
    List<Employee> findAll();
    Page<Employee> findAll(int page, int size);
    List<Employee> findByName(String startWith);
    Page<Employee> findByName(int page, int size, String startWith);
}
