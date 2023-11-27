package com.ejournal.university.department.service.impl;

import com.ejournal.university.common.exception.ResourceNotFoundException;
import com.ejournal.university.department.dto.DepartmentRequestDto;
import com.ejournal.university.department.dto.DepartmentResponseDto;
import com.ejournal.university.department.entity.Department;
import com.ejournal.university.department.mapper.DepartmentMapper;
import com.ejournal.university.department.repository.DepartmentRepository;
import com.ejournal.university.department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentResponseDto create(DepartmentRequestDto requestDto) {
        Department department = DepartmentMapper.mapToEntity(requestDto, new Department());
        return DepartmentMapper.mapToResponseDto(departmentRepository.createDepartment(department));
    }

    @Override
    public DepartmentResponseDto fetchById(Long id) {
        Department department = departmentRepository.findDepartmentById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "id", String.valueOf(id)));
        return DepartmentMapper.mapToResponseDto(department);
    }

    @Override
    public List<DepartmentResponseDto> fetchAll() {
        List<Department> allDepartments = departmentRepository.findAllDepartments();
        return allDepartments.stream()
                .map(DepartmentMapper::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentResponseDto update(Long id, DepartmentRequestDto requestDto) {
        Department department = departmentRepository.findDepartmentById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "id", String.valueOf(id)));
        Department updatedDepartment = DepartmentMapper.mapToEntity(requestDto, department);
        updatedDepartment = departmentRepository.updateDepartment(updatedDepartment);
        return DepartmentMapper.mapToResponseDto(updatedDepartment);
    }

    @Override
    public boolean deleteById(Long id) {
        Department department = departmentRepository.findDepartmentById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "id", String.valueOf(id)));
        departmentRepository.deleteDepartment(department);
        return true;
    }
}
