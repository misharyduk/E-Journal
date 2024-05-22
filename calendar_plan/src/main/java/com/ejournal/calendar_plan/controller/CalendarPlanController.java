package com.ejournal.calendar_plan.controller;

import com.ejournal.calendar_plan.dto.CalendarPlanRecordCreateRequestDto;
import com.ejournal.calendar_plan.dto.CalendarPlanRecordUpdateRequestDto;
import com.ejournal.calendar_plan.dto.CalendarPlanRequestDto;
import com.ejournal.calendar_plan.dto.CalendarPlanResponseDto;
import com.ejournal.calendar_plan.service.CalendarPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calendarplan")
@RequiredArgsConstructor
public class CalendarPlanController {

    private final CalendarPlanService calendarPlanService;

    @GetMapping("/{calendarPlanId}")
    public ResponseEntity<CalendarPlanResponseDto> fetchCalendarPlan(@PathVariable("calendarPlanId") Long calendarPlanId){
        CalendarPlanResponseDto calendarPlan = calendarPlanService.fetchById(calendarPlanId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(calendarPlan);
    }

    @GetMapping("/{calendarPlanId}/short")
    public ResponseEntity<CalendarPlanResponseDto> fetchCalendarPlanInLimit(@PathVariable("calendarPlanId") Long calendarPlanId,
                                                            @RequestParam("limit") Integer limit){
        CalendarPlanResponseDto calendarPlan = calendarPlanService.fetchByIdInLimit(calendarPlanId, limit);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(calendarPlan);
    }

    @PostMapping
    public ResponseEntity<CalendarPlanResponseDto> createCalendarPlan(@RequestBody CalendarPlanRequestDto requestDto){
        CalendarPlanResponseDto calendarPlan = calendarPlanService.createCalendarPlan(requestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(calendarPlan);
    }

    @PostMapping("/{calendarPlanId}/records")
    public ResponseEntity<CalendarPlanResponseDto> addCalendarPlanRecord(@PathVariable("calendarPlanId") Long calendarPlanId,
                                                                         @RequestBody CalendarPlanRecordCreateRequestDto calendarPlanRecordCreateRequestDto){
        CalendarPlanResponseDto calendarPlan = calendarPlanService.addCalendarPlanRecord(calendarPlanId, calendarPlanRecordCreateRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(calendarPlan);
    }

    @PutMapping("/{calendarPlanId}/records/{recordId}")
    public ResponseEntity<CalendarPlanResponseDto> updateCalendarPlanRecord(@PathVariable("calendarPlanId") Long calendarPlanId,
                                                                            @PathVariable("recordId") Long recordId,
                                                                            @RequestBody CalendarPlanRecordUpdateRequestDto requestDto){
        CalendarPlanResponseDto calendarPlan = calendarPlanService.updateCalendarPlanRecord(calendarPlanId, recordId, requestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(calendarPlan);
    }
}
