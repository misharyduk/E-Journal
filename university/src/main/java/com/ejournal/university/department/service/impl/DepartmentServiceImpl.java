package com.ejournal.university.department.service.impl;

import com.ejournal.university.department.dto.DepartmentRequestDto;
import com.ejournal.university.department.dto.DepartmentResponseDto;
import com.ejournal.university.department.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    @Override
    public boolean create(DepartmentRequestDto requestDto) {
        return false;
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
