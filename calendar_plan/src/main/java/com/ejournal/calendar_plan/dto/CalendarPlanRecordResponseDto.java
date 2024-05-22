package com.ejournal.calendar_plan.dto;

import com.ejournal.calendar_plan.entity.CalendarPlanRecord;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data @Builder
public class CalendarPlanRecordResponseDto {

    private Long id;
    private Long lessonId;
    private Integer lessonNumber;
    private Date lessonDate;
    private String themeName;
    private String individualAssignment;
    private Date individualAssignmentDate;

}
