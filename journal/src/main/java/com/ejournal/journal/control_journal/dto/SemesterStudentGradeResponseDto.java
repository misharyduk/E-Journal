package com.ejournal.journal.control_journal.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class SemesterStudentGradeResponseDto {
    private Long id;
    private Long studentId;
    private Double grade;
}
