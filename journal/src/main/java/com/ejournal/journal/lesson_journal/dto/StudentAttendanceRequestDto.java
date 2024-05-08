package com.ejournal.journal.lesson_journal.dto;

import lombok.Data;

import java.util.Date;

@Data
public class StudentAttendanceRequestDto {
    private Long studentId;
    private Long lessonId;
    private String attendanceValue;
}
