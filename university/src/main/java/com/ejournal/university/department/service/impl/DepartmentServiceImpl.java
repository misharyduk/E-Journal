package com.ejournal.university.department.service.impl;

import com.ejournal.university.department.dto.DepartmentRequestDto;
import com.ejournal.university.department.dto.DepartmentResponseDto;
import com.ejournal.university.department.entity.Department;
import com.ejournal.university.department.mapper.DepartmentMapper;
import com.ejournal.university.department.repository.DepartmentRepository;
import com.ejournal.university.department.repository.impl.JpaDepartmentRepositoryImpl;
import com.ejournal.university.department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public List<DepartmentResponseDto> fetchAll() {
        return null;
    }

    @Override
    public DepartmentResponseDto update(DepartmentRequestDto requestDto) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
