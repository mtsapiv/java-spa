package com.mtsapiv.javaspabackend.service;

import com.mtsapiv.javaspabackend.service.dto.DepartmentDTO;
import com.mtsapiv.javaspabackend.service.dto.EmployeeDTO;
import com.mtsapiv.javaspabackend.service.dto.EmployeeResponseDTO;
import com.mtsapiv.javaspabackend.service.dto.EmployeeUpdateDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeResponseDTO save(EmployeeDTO employee);
    void delete(Long id);
    EmployeeResponseDTO update(EmployeeUpdateDTO employee);
    List<EmployeeResponseDTO> findAll(int page, int size);
    List<EmployeeResponseDTO> findByName(int page, int size, String name);
    EmployeeResponseDTO findById(Long id);
    List<DepartmentDTO> findAllDepartments();
}
