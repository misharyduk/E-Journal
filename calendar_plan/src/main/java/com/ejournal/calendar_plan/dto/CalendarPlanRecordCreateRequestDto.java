package com.ejournal.calendar_plan.dto;

import com.ejournal.calendar_plan.entity.CalendarPlan;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
public class CalendarPlanRecordCreateRequestDto {

    private Long lessonId;
    private Integer lessonNumber;
    private Date lessonDate;
    private String themeName;
    private String individualAssignment;
    private Date individualAssignmentDate;

}
