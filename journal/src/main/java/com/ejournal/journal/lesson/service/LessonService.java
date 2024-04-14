package com.ejournal.journal.lesson.service;

import com.ejournal.journal.common.dto.PageableRequestDto;
import com.ejournal.journal.common.dto.PageableResponseDto;
import com.ejournal.journal.common.service.CommonCrudService;
import com.ejournal.journal.journal.dto.JournalResponseDto;
import com.ejournal.journal.lesson.dto.LessonRequestDto;
import com.ejournal.journal.lesson.dto.LessonResponseDto;

public interface LessonService extends CommonCrudService<LessonRequestDto, LessonResponseDto> {

    PageableResponseDto<LessonResponseDto> fetchPageByJournal(Long journalId, PageableRequestDto pageableRequestDto);

    LessonResponseDto update(Long id, LessonRequestDto requestDto);
}
