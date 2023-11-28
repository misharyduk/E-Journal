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
        return DepartmentMapper.mapToDto(departmentRepository.createInstance(department));
    }

    @Override
    public DepartmentResponseDto fetchById(Long id) {
        Department department = departmentRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "id", String.valueOf(id)));
        return DepartmentMapper.mapToDto(department);
    }

    @Override
    public List<DepartmentResponseDto> fetchAll() {
        List<Department> allDepartments = departmentRepository.fetchAllInstances();
        return allDepartments.stream()
                .map(DepartmentMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentResponseDto update(Long id, DepartmentRequestDto requestDto) {
        Department department = departmentRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "id", String.valueOf(id)));
        Department updatedDepartment = DepartmentMapper.mapToEntity(requestDto, department);
        updatedDepartment = departmentRepository.updateInstance(updatedDepartment);
        return DepartmentMapper.mapToDto(updatedDepartment);
    }

    @Override
    public boolean deleteById(Long id) {
        Department department = departmentRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "id", String.valueOf(id)));
        departmentRepository.deleteInstance(department);
        return true;
    }
}
