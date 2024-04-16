package com.ejournal.journal.journal.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.util.List;

@Getter @Setter @NoArgsConstructor
public class AcademicModuleResponseDto {
    private Long id;
    private Integer moduleNumber;
    private List<ExerciseWorkResponseDto> exerciseWorks;

    public AcademicModuleResponseDto(Long id, Integer moduleNumber) {
        this.id = id;
        this.moduleNumber = moduleNumber;
    }
}
