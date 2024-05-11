package com.ejournal.journal.journal.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class AcademicModuleRequestDto {
    private Integer moduleNumber;
    private Date startDate;
    private Date endDate;
    private Date controlWorkExecutionDate;
}
