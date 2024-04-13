package com.ejournal.group.student.service;

import com.ejournal.group.common.dto.PageableRequestDto;
import com.ejournal.group.common.dto.PageableResponseDto;
import com.ejournal.group.common.service.CommonCrudService;
import com.ejournal.group.group.dto.GroupResponseDto;
import com.ejournal.group.student.dto.StudentRequestDto;
import com.ejournal.group.student.dto.StudentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService extends CommonCrudService<StudentRequestDto, StudentResponseDto> {
    PageableResponseDto<StudentResponseDto> fetchPage(PageableRequestDto pageableRequestDto);

    List<StudentResponseDto> fetchByGroupId(Long groupId);

    Long countByGroupId(Long groupId);
}
