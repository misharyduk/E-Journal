package com.ejournal.university.department.service;

import com.ejournal.university.department.dto.DepartmentRequestDto;
import com.ejournal.university.department.dto.DepartmentResponseDto;

import java.util.List;

public interface DepartmentService {

    boolean createDepartment(DepartmentRequestDto departmentRequestDto);

    List<DepartmentResponseDto> fetchAllDepartments();

    DepartmentResponseDto fetchDepartment(Integer departmentId);

    DepartmentResponseDto updateDepartment(DepartmentRequestDto departmentRequestDto);

    boolean deleteDepartment(Integer departmentId);
}
