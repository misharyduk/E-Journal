package com.ejournal.journal.lesson_journal.service;

import com.ejournal.journal.common.dto.PageableRequestDto;
import com.ejournal.journal.common.dto.PageableResponseDto;
import com.ejournal.journal.common.service.CommonCrudService;
import com.ejournal.journal.lesson_journal.dto.LessonRequestDto;
import com.ejournal.journal.lesson_journal.dto.LessonResponseDto;

public interface LessonService extends CommonCrudService<LessonRequestDto, LessonResponseDto> {

    PageableResponseDto<LessonResponseDto> fetchPageByJournal(Long journalId, PageableRequestDto pageableRequestDto);

    LessonResponseDto update(Long id, LessonRequestDto requestDto);
}
