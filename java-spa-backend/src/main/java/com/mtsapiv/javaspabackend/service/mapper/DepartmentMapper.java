package com.mtsapiv.javaspabackend.service.mapper;

import com.mtsapiv.javaspabackend.domain.Department;
import com.mtsapiv.javaspabackend.service.dto.DepartmentDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    Department departmentToDepartmentDTO(DepartmentDTO department);
    DepartmentDTO departmentDTOToDepartment(Department department);
    List<DepartmentDTO> departmentListToDepartmentResponseList(List<Department> departments);
}
