package com.learning.department_service.service.impl;

import com.learning.department_service.dto.DepartmentDto;
import com.learning.department_service.entity.Department;
import com.learning.department_service.exception.DepartmentNotFoundException;
import com.learning.department_service.repository.DepartmentRepository;
import com.learning.department_service.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        return modelMapper.map(departmentRepository.save(modelMapper.map(departmentDto,Department.class)),DepartmentDto.class);
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        return modelMapper.map(departmentRepository.findById(departmentId).orElseThrow(
                ()-> new DepartmentNotFoundException("Department Not Found with ID: " + departmentId)
        ),DepartmentDto.class);
    }


}
