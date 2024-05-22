package com.ejournal.calendar_plan.dto;

import lombok.Data;

import java.util.List;

@Data
public class CalendarPlanRequestDto {
    private Long journalId;
    private List<CalendarLessonRequestDto> calendarLessons;
}
