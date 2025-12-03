package com.learning.employee_service.service;

import com.learning.employee_service.dto.ApiResponse;
import com.learning.employee_service.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    ApiResponse getEmployee(Long id);
}
