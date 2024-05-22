package com.ejournal.calendar_plan.repository.impl;

import com.ejournal.calendar_plan.entity.CalendarPlan;
import com.ejournal.calendar_plan.repository.CalendarPlanRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface JpaCalendarPlanRepositoryImpl extends JpaRepository<CalendarPlan, Long>, CalendarPlanRepository {

    @Override
    default Optional<CalendarPlan> fetchCalendarPlan(Long calendarPlanId){
        return findById(calendarPlanId);
    }

    @Override
    default Optional<CalendarPlan> fetchCalendarPlanInLimit(Long calendarPlanId, Integer limit){
        return findByIdCalendarPlanRecordsLimit(calendarPlanId, limit);
    }

    @Override
    default CalendarPlan saveCalendarPlan(CalendarPlan calendarPlan){
        return save(calendarPlan);
    }

    @Query("FROM CalendarPlan p LEFT JOIN CalendarPlanRecord r WHERE p.id=?1 ORDER BY r.lessonDate LIMIT ?2")
    Optional<CalendarPlan> findByIdCalendarPlanRecordsLimit(Long calendarPlanId, Integer limit);
}
