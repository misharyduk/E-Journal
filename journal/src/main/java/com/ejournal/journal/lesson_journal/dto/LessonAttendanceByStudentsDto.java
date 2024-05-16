package com.ejournal.journal.lesson_journal.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class LessonAttendanceByStudentsDto {
    private Long studentId;
    private List<LessonResponseDto> lessons;
}
