package com.ejournal.calendar_plan.service;

import com.ejournal.calendar_plan.dto.CalendarPlanRecordRequestDto;
import com.ejournal.calendar_plan.dto.CalendarPlanRequestDto;
import com.ejournal.calendar_plan.dto.CalendarPlanResponseDto;

public interface CalendarPlanService {

    CalendarPlanResponseDto fetchById(Long calendarPlanId);

    CalendarPlanResponseDto fetchByIdInLimit(Long calendarPlanId, Integer limit);

    CalendarPlanResponseDto createCalendarPlan(CalendarPlanRequestDto requestDto);

    CalendarPlanResponseDto updateCalendarPlanRecord(Long calendarPlanId, Long recordId, CalendarPlanRecordRequestDto requestDto);

}
