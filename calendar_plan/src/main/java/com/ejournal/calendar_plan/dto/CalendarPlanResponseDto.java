package com.ejournal.calendar_plan.dto;

import com.ejournal.calendar_plan.entity.CalendarPlan;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data @Builder
public class CalendarPlanResponseDto {

    private Long id;
    private List<CalendarPlanRecordResponseDto> calendarPlanRecords;

}
