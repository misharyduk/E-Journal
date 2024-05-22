package com.ejournal.calendar_plan.service.impl;

import com.ejournal.calendar_plan.dto.CalendarPlanRecordRequestDto;
import com.ejournal.calendar_plan.dto.CalendarPlanRecordResponseDto;
import com.ejournal.calendar_plan.dto.CalendarPlanRequestDto;
import com.ejournal.calendar_plan.dto.CalendarPlanResponseDto;
import com.ejournal.calendar_plan.entity.CalendarPlan;
import com.ejournal.calendar_plan.entity.CalendarPlanRecord;
import com.ejournal.calendar_plan.exception.ResourceNotFoundException;
import com.ejournal.calendar_plan.repository.CalendarPlanRecordRepository;
import com.ejournal.calendar_plan.repository.CalendarPlanRepository;
import com.ejournal.calendar_plan.service.CalendarPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CalendarPlanServiceImpl implements CalendarPlanService {

    private final CalendarPlanRepository calendarPlanRepository;
    private final CalendarPlanRecordRepository calendarPlanRecordRepository;

    @Override
    public CalendarPlanResponseDto fetchById(Long calendarPlanId) {
        Optional<CalendarPlan> calendarPlanOpt = calendarPlanRepository.fetchCalendarPlan(calendarPlanId);
        if(calendarPlanOpt.isEmpty())
            throw new ResourceNotFoundException("Calendar plan", "id", String.valueOf(calendarPlanId));

        CalendarPlan calendarPlan = calendarPlanOpt.get();
        return mapCalendarPlanResponseDto(calendarPlan);
    }

    @Override
    public CalendarPlanResponseDto fetchByIdInLimit(Long calendarPlanId, Integer limit) {
        Optional<CalendarPlan> calendarPlanOpt = calendarPlanRepository.fetchCalendarPlanInLimit(calendarPlanId, limit);
        if(calendarPlanOpt.isEmpty())
            throw new ResourceNotFoundException("Calendar plan", "id", String.valueOf(calendarPlanId));

        CalendarPlan calendarPlan = calendarPlanOpt.get();
        return mapCalendarPlanResponseDto(calendarPlan);
    }

    @Override
    public CalendarPlanResponseDto createCalendarPlan(CalendarPlanRequestDto requestDto) {
        CalendarPlan calendarPlan = new CalendarPlan();
        calendarPlan.setJournalId(requestDto.getJournalId());
        requestDto.getCalendarLessons().stream()
                .map(l -> new CalendarPlanRecord(l.getLessonId(), l.getLessonDate()))
                .forEach(l -> calendarPlan.getCalendarPlanRecords().add(l));

        calendarPlan.getCalendarPlanRecords().forEach(calendarPlanRecordRepository::saveCalendarPlanRecord);

        CalendarPlan calendarPlanFromDb = calendarPlanRepository.saveCalendarPlan(calendarPlan);
        return mapCalendarPlanResponseDto(calendarPlanFromDb);
    }

    @Override
    public CalendarPlanResponseDto updateCalendarPlanRecord(Long calendarPlanId, Long recordId, CalendarPlanRecordRequestDto requestDto) {
        Optional<CalendarPlan> calendarPlanOpt = calendarPlanRepository.fetchCalendarPlan(calendarPlanId);
        if(calendarPlanOpt.isEmpty())
            throw new ResourceNotFoundException("Calendar plan", "id", String.valueOf(calendarPlanId));

        CalendarPlan calendarPlan = calendarPlanOpt.get();
        CalendarPlanRecord calendarPlanRecord = calendarPlan.getCalendarPlanRecords().stream()
                .filter(r -> r.getId().equals(recordId))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Calendar Plan Record", "id", String.valueOf(recordId)));

        mapCalendarPlanRecord(calendarPlanRecord, requestDto);

        calendarPlanRecordRepository.saveCalendarPlanRecord(calendarPlanRecord);

        CalendarPlan calendarPlanFromDb = calendarPlanRepository.saveCalendarPlan(calendarPlan);
        return mapCalendarPlanResponseDto(calendarPlanFromDb);
    }

    private static void mapCalendarPlanRecord(CalendarPlanRecord calendarPlanRecord, CalendarPlanRecordRequestDto requestDto){
        calendarPlanRecord.setLessonNumber(requestDto.getLessonNumber());
        calendarPlanRecord.setThemeName(requestDto.getThemeName());
        calendarPlanRecord.setIndividualAssignment(requestDto.getIndividualAssignment());
        calendarPlanRecord.setIndividualAssignmentDate(requestDto.getIndividualAssignmentDate());
    }

    private static CalendarPlanResponseDto mapCalendarPlanResponseDto(CalendarPlan calendarPlan) {
        return CalendarPlanResponseDto.builder()
                .id(calendarPlan.getId())
                .calendarPlanRecords(calendarPlan.getCalendarPlanRecords().stream()
                        .map(r -> CalendarPlanRecordResponseDto.builder()
                                .id(r.getId())
                                .lessonId(r.getLessonId())
                                .lessonNumber(r.getLessonNumber())
                                .lessonDate(r.getLessonDate())
                                .themeName(r.getThemeName())
                                .individualAssignment(r.getIndividualAssignment())
                                .individualAssignmentDate(r.getIndividualAssignmentDate())
                                .build()).toList())
                .build();
    }
}
