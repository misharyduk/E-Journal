package com.ejournal.journal.exercise_journal.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data @Builder
public class WorkStudentMarkResponseDto {
    private Long id;
    private Long studentId;
    private Date executionDate;
    private Date defendDate;
    private Float mark;
}
