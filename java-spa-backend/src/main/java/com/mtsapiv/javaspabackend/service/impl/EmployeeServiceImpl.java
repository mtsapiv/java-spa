package com.mtsapiv.javaspabackend.service.impl;

import com.mtsapiv.javaspabackend.domain.Department;
import com.mtsapiv.javaspabackend.domain.Employee;
import com.mtsapiv.javaspabackend.repository.DepartmentRepository;
import com.mtsapiv.javaspabackend.repository.EmployeeRepository;
import com.mtsapiv.javaspabackend.service.EmployeeService;
import com.mtsapiv.javaspabackend.service.dto.DepartmentDTO;
import com.mtsapiv.javaspabackend.service.dto.EmployeeDTO;
import com.mtsapiv.javaspabackend.service.dto.EmployeeResponseDTO;
import com.mtsapiv.javaspabackend.service.dto.EmployeeUpdateDTO;
import com.mtsapiv.javaspabackend.service.mapper.DepartmentMapper;
import com.mtsapiv.javaspabackend.service.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeMapper employeeMapper;
    private final DepartmentMapper departmentMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, EmployeeMapper employeeMapper, DepartmentMapper departmentMapper) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.employeeMapper = employeeMapper;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public EmployeeResponseDTO save(EmployeeDTO employee) {
        Employee newEmployee = employeeMapper.employeeDTOToEmployee(employee);
        Long id = employeeRepository.save(newEmployee);
        return employeeMapper.employeeToResponseDTO(
                employeeRepository.getOne(id));
    }

    @Override
    public void delete(Long id) {
        employeeRepository.delete(id);
    }

    @Override
    public EmployeeResponseDTO update(EmployeeUpdateDTO employee) {
        Employee newEmployee = employeeMapper.employeeUpdateDTOToEmployee(employee);
        employeeRepository.update(newEmployee);
        return employeeMapper.employeeToResponseDTO(
                employeeRepository.getOne(employee.getId()));
    }

    @Override
    public List<EmployeeResponseDTO> findAll(int page, int size) {
        List<Employee> employees = employeeRepository.findAll(page, size);
        return employeeMapper.employeeListToEmployeeResponseList(employees);
    }

    @Override
    public List<EmployeeResponseDTO> findByName(int page, int size, String name) {
        List<Employee> employees = employeeRepository.findByName(page, size, name);
        return employeeMapper.employeeListToEmployeeResponseList(employees);
    }

    @Override
    public EmployeeResponseDTO findById(Long id) {
        Employee employee = employeeRepository.getOne(id);

        return employeeMapper.employeeToResponseDTO(employee);
    }

    @Override
    public List<DepartmentDTO> findAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departmentMapper.departmentListToDepartmentResponseList(departments);
    }
}
