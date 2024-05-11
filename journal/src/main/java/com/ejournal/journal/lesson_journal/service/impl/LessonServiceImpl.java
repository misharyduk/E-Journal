package com.ejournal.journal.lesson_journal.service.impl;

import com.ejournal.journal.common.dto.PageableRequestDto;
import com.ejournal.journal.common.dto.PageableResponseDto;
import com.ejournal.journal.common.exception.ResourceNotFoundException;
import com.ejournal.journal.journal.entity.Journal;
import com.ejournal.journal.journal.repository.JournalRepository;
import com.ejournal.journal.lesson_journal.dto.LessonRequestDto;
import com.ejournal.journal.lesson_journal.dto.LessonResponseDto;
import com.ejournal.journal.lesson_journal.entity.Lesson;
import com.ejournal.journal.lesson_journal.mapper.LessonMapper;
import com.ejournal.journal.lesson_journal.repository.LessonRepository;
import com.ejournal.journal.lesson_journal.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final JournalRepository journalRepository;

    @Override
    public LessonResponseDto fetchById(Long id) {
        Lesson lessonFromDb = lessonRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson", "id", String.valueOf(id)));
        return LessonMapper.mapToDto(lessonFromDb, new LessonResponseDto());
    }

    @Override
    public LessonResponseDto update(Long id, LessonRequestDto requestDto) {
        Lesson lesson = lessonRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson", "id", String.valueOf(id)));
        Lesson updatedLesson = LessonMapper.mapToEntity(requestDto, lesson);

        updatedLesson = lessonRepository.updateInstance(updatedLesson);
        return LessonMapper.mapToDto(updatedLesson, new LessonResponseDto());
    }

    @Override
    public boolean deleteById(Long id) {
        Lesson lesson = lessonRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson", "id", String.valueOf(id)));
        lessonRepository.deleteInstance(lesson);
        return true;
    }

    @Override
    public PageableResponseDto<LessonResponseDto> fetchPageByJournal(Long journalId, PageableRequestDto pageableRequestDto) {
        Pageable pageable = PageRequest.of(pageableRequestDto.getPage() - 1, pageableRequestDto.getSize())
                .withSort(Sort.Direction.ASC, "date");
        Page<Lesson> lessonsPage = lessonRepository.fetchPage(pageable);
        return new PageableResponseDto<>(
                lessonsPage.getTotalPages(),
                pageableRequestDto.getPage(),
                pageableRequestDto.getSize(),
                pageableRequestDto.getDir(),
                lessonsPage.getTotalElements(),
                lessonsPage.stream().map((l) -> LessonMapper.mapToDto(l, new LessonResponseDto())).toList()
        );
    }


}
