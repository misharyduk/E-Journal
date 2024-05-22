package com.ejournal.calendar_plan.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
public class CalendarPlanRecordRequestDto {

    private Long lessonNumber;
    private String themeName;
    private String individualAssignment;
    private Date individualAssignmentDate;

}
