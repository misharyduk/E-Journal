package com.ejournal.calendar_plan.service.impl;

import com.ejournal.calendar_plan.dto.*;
import com.ejournal.calendar_plan.entity.CalendarPlan;
import com.ejournal.calendar_plan.entity.CalendarPlanRecord;
import com.ejournal.calendar_plan.exception.ResourceNotFoundException;
import com.ejournal.calendar_plan.repository.CalendarPlanRecordRepository;
import com.ejournal.calendar_plan.repository.CalendarPlanRepository;
import com.ejournal.calendar_plan.service.CalendarPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
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
        List<CalendarPlanRecord> calendarPlanRecords = calendarPlanRecordRepository.fetchCalendarPlanRecordInLimitByCalendar(calendarPlan.getId(), limit);

        return mapCalendarPlanResponseDto(calendarPlan, calendarPlanRecords);
    }

    @Override
    public CalendarPlanResponseDto createCalendarPlan(CalendarPlanRequestDto requestDto) {
        CalendarPlan calendarPlan = new CalendarPlan();
        calendarPlan.setJournalId(requestDto.getJournalId());
        requestDto.getCalendarLessons().stream()
                .map(l -> new CalendarPlanRecord(l.getLessonId(), l.getLessonDate()))
                .peek(l -> l.setCalendarPlan(calendarPlan))
                .forEach(l -> calendarPlan.getCalendarPlanRecords().add(l));

        CalendarPlan calendarPlanFromDb = calendarPlanRepository.saveCalendarPlan(calendarPlan);
        return mapCalendarPlanResponseDto(calendarPlanFromDb);
    }

    @Override
    public CalendarPlanResponseDto addCalendarPlanRecord(Long calendarPlanId, CalendarPlanRecordCreateRequestDto calendarPlanRecordCreateRequestDto) {
        Optional<CalendarPlan> calendarPlanOpt = calendarPlanRepository.fetchCalendarPlan(calendarPlanId);
        if(calendarPlanOpt.isEmpty())
            throw new ResourceNotFoundException("Calendar plan", "id", String.valueOf(calendarPlanId));

        CalendarPlan calendarPlan = calendarPlanOpt.get();

        CalendarPlanRecord calendarPlanRecord = new CalendarPlanRecord();
        mapCalendarPlanCreateRecord(calendarPlanRecord, calendarPlanRecordCreateRequestDto);
        calendarPlanRecord.setCalendarPlan(calendarPlan);

        calendarPlan.getCalendarPlanRecords().add(calendarPlanRecord);

        CalendarPlan calendarPlanFromDb = calendarPlanRepository.saveCalendarPlan(calendarPlan);
        return mapCalendarPlanResponseDto(calendarPlanFromDb);
    }

    @Override
    public CalendarPlanResponseDto updateCalendarPlanRecord(Long calendarPlanId, Long recordId, CalendarPlanRecordUpdateRequestDto requestDto) {
        Optional<CalendarPlan> calendarPlanOpt = calendarPlanRepository.fetchCalendarPlan(calendarPlanId);
        if(calendarPlanOpt.isEmpty())
            throw new ResourceNotFoundException("Calendar plan", "id", String.valueOf(calendarPlanId));

        CalendarPlan calendarPlan = calendarPlanOpt.get();
        CalendarPlanRecord calendarPlanRecord = calendarPlan.getCalendarPlanRecords().stream()
                .filter(r -> r.getId().equals(recordId))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Calendar Plan Record", "id", String.valueOf(recordId)));

        mapCalendarPlanUpdateRecord(calendarPlanRecord, requestDto);

        // TODO remove this saving
        calendarPlanRecordRepository.saveCalendarPlanRecord(calendarPlanRecord);

        CalendarPlan calendarPlanFromDb = calendarPlanRepository.saveCalendarPlan(calendarPlan);
        return mapCalendarPlanResponseDto(calendarPlanFromDb);
    }

    private void mapCalendarPlanCreateRecord(CalendarPlanRecord calendarPlanRecord, CalendarPlanRecordCreateRequestDto requestDto) {
        calendarPlanRecord.setLessonId(requestDto.getLessonId());
        calendarPlanRecord.setLessonNumber(requestDto.getLessonNumber());
        calendarPlanRecord.setLessonDate(requestDto.getLessonDate());
        calendarPlanRecord.setThemeName(requestDto.getThemeName());
        calendarPlanRecord.setIndividualAssignment(requestDto.getIndividualAssignment());
        calendarPlanRecord.setIndividualAssignmentDate(requestDto.getIndividualAssignmentDate());
    }

    private static void mapCalendarPlanUpdateRecord(CalendarPlanRecord calendarPlanRecord, CalendarPlanRecordUpdateRequestDto requestDto){
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

    private static CalendarPlanResponseDto mapCalendarPlanResponseDto(CalendarPlan calendarPlan, List<CalendarPlanRecord> calendarPlanRecords) {
        return CalendarPlanResponseDto.builder()
                .id(calendarPlan.getId())
                .calendarPlanRecords(calendarPlanRecords.stream()
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
