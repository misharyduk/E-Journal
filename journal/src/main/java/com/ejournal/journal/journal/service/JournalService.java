package com.ejournal.journal.journal.service;

import com.ejournal.journal.common.dto.PageableRequestDto;
import com.ejournal.journal.common.dto.PageableResponseDto;
import com.ejournal.journal.common.service.CommonCrudService;
import com.ejournal.journal.journal.dto.JournalRequestDto;
import com.ejournal.journal.journal.dto.JournalResponseDto;

import java.util.List;

public interface JournalService extends CommonCrudService<JournalRequestDto, JournalResponseDto> {

    JournalResponseDto fetchById(Long id, PageableRequestDto pageableRequestDto);

    List<JournalResponseDto> fetchAll();

    PageableResponseDto<JournalResponseDto> fetchPage(PageableRequestDto pageableRequestDto);

    List<JournalResponseDto> fetchAllBySubject(Long subjectId);

    List<JournalResponseDto> fetchAllByTeacher(Long teacherId);

    List<JournalResponseDto> fetchAllByGroup(Long groupId);

}
