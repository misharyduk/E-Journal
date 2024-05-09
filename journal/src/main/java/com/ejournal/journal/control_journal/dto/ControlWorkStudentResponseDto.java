package com.ejournal.journal.control_journal.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;

@Data @AllArgsConstructor @NoArgsConstructor
public class ControlWorkStudentResponseDto {
    private Long id;
    private Long studentId;
    private Double mark;
}
