package com.ejournal.journal.journal.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class AcademicModuleResponseDto {
    private Long id;
    private Integer moduleNumber;
}
