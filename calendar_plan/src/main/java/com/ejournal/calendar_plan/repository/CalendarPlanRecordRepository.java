package com.ejournal.calendar_plan.repository;

import com.ejournal.calendar_plan.entity.CalendarPlan;
import com.ejournal.calendar_plan.entity.CalendarPlanRecord;

import java.util.List;
import java.util.Optional;

public interface CalendarPlanRecordRepository {

    List<CalendarPlanRecord> fetchCalendarPlanRecordInLimitByCalendar(Long calendarPlanId, Integer limit);

    CalendarPlanRecord saveCalendarPlanRecord(CalendarPlanRecord calendarPlanRecord);

}
