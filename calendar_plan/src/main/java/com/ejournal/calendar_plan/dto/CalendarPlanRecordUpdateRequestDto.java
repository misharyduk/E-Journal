package com.ejournal.calendar_plan.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CalendarPlanRecordUpdateRequestDto {

    private Integer lessonNumber;
    private String themeName;
    private String individualAssignment;
    private Date individualAssignmentDate;

}
