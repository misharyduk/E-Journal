package com.ejournal.calendar_plan.repository.impl;

import com.ejournal.calendar_plan.entity.CalendarPlanRecord;
import com.ejournal.calendar_plan.repository.CalendarPlanRecordRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCalendarPlanRecordRepositoryImpl extends JpaRepository<CalendarPlanRecord, Long>, CalendarPlanRecordRepository {
    @Override
    default CalendarPlanRecord saveCalendarPlanRecord(CalendarPlanRecord calendarPlanRecord){
        return save(calendarPlanRecord);
    }

}
