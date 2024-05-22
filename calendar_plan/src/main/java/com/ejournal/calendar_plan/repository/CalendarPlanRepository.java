package com.ejournal.calendar_plan.repository;

import com.ejournal.calendar_plan.entity.CalendarPlan;

import java.util.Optional;

public interface CalendarPlanRepository {

    Optional<CalendarPlan> fetchCalendarPlan(Long calendarPlanId);

    Optional<CalendarPlan> fetchCalendarPlanInLimit(Long calendarPlanId, Integer limit);

    CalendarPlan saveCalendarPlan(CalendarPlan calendarPlan);
}
