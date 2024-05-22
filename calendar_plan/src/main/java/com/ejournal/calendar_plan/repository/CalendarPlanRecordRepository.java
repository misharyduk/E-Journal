package com.ejournal.calendar_plan.repository;

import com.ejournal.calendar_plan.entity.CalendarPlan;
import com.ejournal.calendar_plan.entity.CalendarPlanRecord;

import java.util.Optional;

public interface CalendarPlanRecordRepository {

    CalendarPlanRecord saveCalendarPlanRecord(CalendarPlanRecord calendarPlanRecord);

}
