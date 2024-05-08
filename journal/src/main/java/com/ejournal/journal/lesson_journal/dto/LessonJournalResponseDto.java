package com.ejournal.journal.lesson_journal.dto;

import com.ejournal.journal.exercise_journal.dto.WorkStudentMarkResponseDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data @Builder
public class LessonJournalResponseDto {

    private Long id;
    private List<LessonResponseDto> lessons;

}
