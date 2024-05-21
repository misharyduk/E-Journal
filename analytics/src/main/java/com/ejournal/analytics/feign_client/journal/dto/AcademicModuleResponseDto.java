package com.ejournal.analytics.feign_client.journal.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter @NoArgsConstructor
public class AcademicModuleResponseDto {
    private Long id;
    private Integer moduleNumber;
    private Date startDate;
    private Date endDate;

    public AcademicModuleResponseDto(Long id, Integer moduleNumber, Date startDate, Date endDate) {
        this.id = id;
        this.moduleNumber = moduleNumber;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
