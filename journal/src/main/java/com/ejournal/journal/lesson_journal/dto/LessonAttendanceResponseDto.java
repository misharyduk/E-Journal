package com.ejournal.journal.lesson_journal.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class LessonAttendanceResponseDto {
    private Long id;
    private Long studentId;
    private Long lessonId;
    private String attendanceValue;
}
