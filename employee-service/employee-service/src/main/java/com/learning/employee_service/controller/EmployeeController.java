package com.learning.employee_service.controller;


import com.learning.employee_service.dto.ApiResponse;
import com.learning.employee_service.dto.EmployeeDto;
import com.learning.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeService.createEmployee(employeeDto), HttpStatus.CREATED);
    }

//    @GetMapping("{id}")
//    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id) {
//        return ResponseEntity.ok(employeeService.getEmployee(id));
//    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse> getEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployee(id));
    }
}
