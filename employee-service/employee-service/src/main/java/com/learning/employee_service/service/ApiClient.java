package com.learning.employee_service.service;

import com.learning.employee_service.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "department-service")
public interface ApiClient {

    @GetMapping("/api/departments/{id}")
    DepartmentDto getDepartmentById(@PathVariable String id);
}
