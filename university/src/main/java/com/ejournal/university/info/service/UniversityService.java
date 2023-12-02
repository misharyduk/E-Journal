package com.ejournal.university.info.service;

import com.ejournal.university.common.dto.PageableRequestDto;
import com.ejournal.university.common.dto.PageableResponseDto;
import com.ejournal.university.common.service.CommonCrudService;
import com.ejournal.university.faculty.dto.FacultyResponseDto;
import com.ejournal.university.info.dto.UniversityResponseDto;
import com.ejournal.university.info.dto.UniversityRequestDto;

public interface UniversityService extends CommonCrudService<UniversityRequestDto, UniversityResponseDto> {

    PageableResponseDto<UniversityResponseDto> fetchPage(PageableRequestDto pageableRequestDto);

}
