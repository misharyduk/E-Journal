package com.ejournal.journal.common.feign_client.calendar_plan.dto;

import lombok.Data;

import java.util.List;

@Data
public class CalendarPlanRequestDto {
    private Long journalId;
    private List<CalendarLessonRequestDto> calendarLessons;
}
