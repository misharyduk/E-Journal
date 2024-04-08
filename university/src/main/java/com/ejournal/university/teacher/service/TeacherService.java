package com.ejournal.university.teacher.service;

import com.ejournal.university.common.dto.PageableRequestDto;
import com.ejournal.university.common.dto.PageableResponseDto;
import com.ejournal.university.common.service.CommonCrudService;
import com.ejournal.university.info.dto.UniversityResponseDto;
import com.ejournal.university.teacher.dto.TeacherRequestDto;
import com.ejournal.university.teacher.dto.TeacherResponseDto;

public interface TeacherService extends CommonCrudService<TeacherRequestDto, TeacherResponseDto> {

    PageableResponseDto<TeacherResponseDto> fetchPage(PageableRequestDto pageableRequestDto);

}
