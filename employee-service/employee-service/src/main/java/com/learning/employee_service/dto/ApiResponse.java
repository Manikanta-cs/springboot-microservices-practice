package com.learning.employee_service.dto;

public class ApiResponse {
    private EmployeeDto employee;
    private DepartmentDto department;

    public ApiResponse() {
    }

    public ApiResponse(EmployeeDto employee, DepartmentDto department) {
        this.employee = employee;
        this.department = department;
    }

    public EmployeeDto getEmployee() {
        return employee;
    }

    public DepartmentDto getDepartment() {
        return department;
    }

    public void setEmployee(EmployeeDto employee) {
        this.employee = employee;
    }

    public void setDepartment(DepartmentDto department) {
        this.department = department;
    }
}
