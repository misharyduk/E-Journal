package com.ejournal.journal.lesson_journal.dto;

import com.ejournal.journal.lesson_journal.entity.LessonAttendance;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
public class LessonResponseDto {
    private Long id;
    private String type;
    private Date date;
    private Integer order;
    private String auditory;
    private List<LessonAttendanceResponseDto> lessonAttendances;
}
