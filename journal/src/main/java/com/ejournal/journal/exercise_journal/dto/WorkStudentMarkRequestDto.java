package com.ejournal.journal.exercise_journal.dto;

import lombok.Data;

import java.util.Date;

@Data
public class WorkStudentMarkRequestDto {
    private Long studentId;
    private Long exerciseWorkId;
    private Date executionDate;
    private Date defendDate;
    private Float mark;
}
