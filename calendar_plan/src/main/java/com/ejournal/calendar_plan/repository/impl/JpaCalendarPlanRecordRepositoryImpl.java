package com.ejournal.calendar_plan.repository.impl;

import com.ejournal.calendar_plan.entity.CalendarPlanRecord;
import com.ejournal.calendar_plan.repository.CalendarPlanRecordRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaCalendarPlanRecordRepositoryImpl extends JpaRepository<CalendarPlanRecord, Long>, CalendarPlanRecordRepository {
    @Override
    default CalendarPlanRecord saveCalendarPlanRecord(CalendarPlanRecord calendarPlanRecord){
        return save(calendarPlanRecord);
    }

    @Override
    default List<CalendarPlanRecord> fetchCalendarPlanRecordInLimitByCalendar(Long calendarPlanId, Integer limit){
        PageRequest pageable = PageRequest.of(0, limit);
        return findByCalendarPlanIdOrderByLessonDate(calendarPlanId, pageable);
    }

    List<CalendarPlanRecord> findByCalendarPlanIdOrderByLessonDate(Long calendarPlanId, Pageable pageable);
}
