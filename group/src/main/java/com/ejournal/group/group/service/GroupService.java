package com.ejournal.group.group.service;

import com.ejournal.group.common.dto.PageableRequestDto;
import com.ejournal.group.common.dto.PageableResponseDto;
import com.ejournal.group.common.service.CommonCrudService;
import com.ejournal.group.group.dto.GroupRequestDto;
import com.ejournal.group.group.dto.GroupResponseDto;
import com.ejournal.group.student.dto.StudentResponseDto;

public interface GroupService extends CommonCrudService<GroupRequestDto, GroupResponseDto> {
    PageableResponseDto<GroupResponseDto> fetchPage(PageableRequestDto pageableRequestDto);
}
