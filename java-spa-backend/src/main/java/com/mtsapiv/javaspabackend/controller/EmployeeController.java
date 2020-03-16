package com.mtsapiv.javaspabackend.controller;

import com.mtsapiv.javaspabackend.domain.Department;
import com.mtsapiv.javaspabackend.service.EmployeeService;
import com.mtsapiv.javaspabackend.service.dto.DepartmentDTO;
import com.mtsapiv.javaspabackend.service.dto.EmployeeDTO;
import com.mtsapiv.javaspabackend.service.dto.EmployeeResponseDTO;
import com.mtsapiv.javaspabackend.service.dto.EmployeeUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
@CrossOrigin
public class EmployeeController {


    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@RequestParam Long id) {
        EmployeeResponseDTO employeeResponseDTO = employeeService.findById(id);
        return new ResponseEntity<>(employeeResponseDTO, HttpStatus.OK);
    }

    @GetMapping("employees")
    public ResponseEntity<Page<EmployeeResponseDTO>> getEmployees(@RequestParam int page, @RequestParam int size) {
        Page<EmployeeResponseDTO> employees = employeeService.findAll(page, size);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("employees/find")
    public ResponseEntity<Page<EmployeeResponseDTO>> getEmployeesByName(@RequestParam int page, @RequestParam int size, @RequestParam String name) {
        Page<EmployeeResponseDTO> employees = employeeService.findByName(page, size, name);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<EmployeeResponseDTO> save(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeResponseDTO employeeResponseDTO = employeeService.save(employeeDTO);
        return new ResponseEntity<>(employeeResponseDTO, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<EmployeeResponseDTO> update(@RequestBody EmployeeUpdateDTO employeeDTO) {
        EmployeeResponseDTO employeeResponseDTO = employeeService.update(employeeDTO);
        return new ResponseEntity<>(employeeResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<EmployeeResponseDTO> delete(@RequestParam Long id) {
        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("departments")
    public ResponseEntity<List<DepartmentDTO>> getDepartments() {
        List<DepartmentDTO> departments = employeeService.findAllDepartments();
        return new ResponseEntity<>(departments, HttpStatus.OK);

    }
}
