package com.ejournal.analytics.feign_client.journal.dto;

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
