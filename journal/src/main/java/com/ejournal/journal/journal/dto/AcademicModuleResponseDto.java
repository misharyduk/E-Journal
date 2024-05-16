package com.ejournal.journal.journal.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter @Setter @NoArgsConstructor
public class AcademicModuleResponseDto {
    private Long id;
    private Integer moduleNumber;
    private Date startDate;
    private Date endDate;
    private List<ExerciseWorkResponseDto> exerciseWorks;
    private ControlWorkResponseDto controlWork;

    public AcademicModuleResponseDto(Long id, Integer moduleNumber, Date startDate, Date endDate) {
        this.id = id;
        this.moduleNumber = moduleNumber;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
