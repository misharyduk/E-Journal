package com.ejournal.university.department.service.impl;

import com.ejournal.university.department.dto.DepartmentRequestDto;
import com.ejournal.university.department.dto.DepartmentResponseDto;
import com.ejournal.university.department.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public boolean createDepartment(DepartmentRequestDto departmentRequestDto) {
        return false;
    }

    @Override
    public List<DepartmentResponseDto> fetchAllDepartments() {
        return null;
    }

    @Override
    public DepartmentResponseDto fetchDepartment(Integer departmentId) {
        return null;
    }

    @Override
    public DepartmentResponseDto updateDepartment(DepartmentRequestDto departmentRequestDto) {
        return null;
    }

    @Override
    public boolean deleteDepartment(Integer departmentId) {
        return false;
    }
}
