package com.ejournal.university.faculty.service;

import com.ejournal.university.common.dto.PageableRequestDto;
import com.ejournal.university.common.dto.PageableResponseDto;
import com.ejournal.university.common.service.CommonCrudService;
import com.ejournal.university.faculty.dto.FacultyRequestDto;
import com.ejournal.university.faculty.dto.FacultyResponseDto;

import java.util.List;

public interface FacultyService extends CommonCrudService<FacultyRequestDto, FacultyResponseDto> {
    PageableResponseDto<FacultyResponseDto> fetchPage(PageableRequestDto pageableRequestDto);
}
