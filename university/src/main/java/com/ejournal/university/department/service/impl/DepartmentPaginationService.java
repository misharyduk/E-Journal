package com.ejournal.university.department.service.impl;

import com.ejournal.university.common.dto.PageableRequestDto;
import com.ejournal.university.common.dto.PageableResponseDto;
import com.ejournal.university.common.util.SortFieldValidator;
import com.ejournal.university.department.dto.DepartmentResponseDto;
import com.ejournal.university.department.entity.Department;
import com.ejournal.university.department.mapper.DepartmentMapper;
import com.ejournal.university.department.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentPaginationService {

    private final DepartmentRepository departmentRepository;

    public PageableResponseDto<DepartmentResponseDto> fetchPage(PageableRequestDto pageableRequestDto) {
        SortFieldValidator.DepartmentField validSortFieldName = SortFieldValidator.DepartmentField.validate(pageableRequestDto.getField());
        return switch (validSortFieldName) {
            case DEPARTMENT_ID, DEPARTMENT_NAME -> fetchOnBasicField(pageableRequestDto, validSortFieldName.getValidHQLField());
            case STUDENTS -> fetchOnNumberOfStudents(pageableRequestDto);
        };
    }

    private PageableResponseDto<DepartmentResponseDto> fetchOnBasicField(PageableRequestDto pageableRequestDto, String field) {

        PageRequest pageable = PageRequest.of(pageableRequestDto.getPage() - 1, pageableRequestDto.getSize())
                .withSort(Sort.Direction.fromString(pageableRequestDto.getDir()), field);

        Page<Department> pageOfDepartments = departmentRepository.fetchPage(pageable);
        var listOfDepartmentDTOs = pageOfDepartments.stream()
                .map(DepartmentMapper::mapToDto)
                .toList();

        return new PageableResponseDto<>(
                pageOfDepartments.getTotalPages(),
                pageableRequestDto.getPage(),
                pageOfDepartments.getSize(),
                field,
                pageOfDepartments.getTotalElements(),
                listOfDepartmentDTOs
        );

    }

    private PageableResponseDto<DepartmentResponseDto> fetchOnNumberOfStudents(PageableRequestDto pageableRequestDto) {
        // TODO implement method
        return null;
    }

}
