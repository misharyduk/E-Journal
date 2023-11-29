package com.ejournal.university.department.service;

import com.ejournal.university.common.dto.PageableRequestDto;
import com.ejournal.university.common.dto.PageableResponseDto;
import com.ejournal.university.common.service.CommonCrudService;
import com.ejournal.university.department.dto.DepartmentRequestDto;
import com.ejournal.university.department.dto.DepartmentResponseDto;

import java.util.List;

public interface DepartmentService extends CommonCrudService<DepartmentRequestDto, DepartmentResponseDto> {

    PageableResponseDto<DepartmentResponseDto> fetchPage(PageableRequestDto pageableRequestDto);

}
