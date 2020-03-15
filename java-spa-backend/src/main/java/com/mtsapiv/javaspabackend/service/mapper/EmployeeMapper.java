package com.mtsapiv.javaspabackend.service.mapper;

import com.mtsapiv.javaspabackend.domain.Department;
import com.mtsapiv.javaspabackend.domain.Employee;
import com.mtsapiv.javaspabackend.service.dto.EmployeeDTO;
import com.mtsapiv.javaspabackend.service.dto.EmployeeResponseDTO;
import com.mtsapiv.javaspabackend.service.dto.EmployeeUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(source = "departmentId", target = "department.id")
    Employee employeeDTOToEmployee(EmployeeDTO employeeDTO);

    @Mapping(source = "department.name", target = "department")
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    EmployeeResponseDTO employeeToResponseDTO(Employee employee);

    @Mapping(source = "departmentId", target = "department.id")
    Employee employeeUpdateDTOToEmployee(EmployeeUpdateDTO employee);

    List<EmployeeResponseDTO> employeeListToEmployeeResponseList(List<Employee> employees);


}
