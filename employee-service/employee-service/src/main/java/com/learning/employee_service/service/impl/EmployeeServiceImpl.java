package com.learning.employee_service.service.impl;

import com.learning.employee_service.dto.ApiResponse;
import com.learning.employee_service.dto.DepartmentDto;
import com.learning.employee_service.dto.EmployeeDto;
import com.learning.employee_service.entity.Employee;
import com.learning.employee_service.exception.EmployeeNotFoundException;
import com.learning.employee_service.repository.EmployeeRepository;
import com.learning.employee_service.service.ApiClient;
import com.learning.employee_service.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;

    @Autowired
    private ApiClient apiClient;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        return modelMapper.map(employeeRepository.save(modelMapper.map(employeeDto, Employee.class
        )), EmployeeDto.class);
    }

    @Override
    public ApiResponse getEmployee(Long id) {
        EmployeeDto employeeDto = modelMapper.map(employeeRepository.findById(id).orElseThrow(
                ()-> new EmployeeNotFoundException("Employee Not Found with ID: " + id)
        ),EmployeeDto.class);

//        DepartmentDto departmentDto = restTemplate.getForObject("http://localhost:9090/api/departments/" + employeeDto.getDepartmentCode(), DepartmentDto.class);

//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:9090/api/departments/" + employeeDto.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();

        DepartmentDto departmentDto = apiClient.getDepartmentById(employeeDto.getDepartmentCode());

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setEmployee(employeeDto);
        apiResponse.setDepartment(departmentDto);

        return apiResponse;
    }
}
