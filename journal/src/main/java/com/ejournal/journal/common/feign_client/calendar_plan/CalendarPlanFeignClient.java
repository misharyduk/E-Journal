package com.ejournal.journal.common.feign_client.calendar_plan;

import com.ejournal.journal.common.feign_client.calendar_plan.dto.CalendarLessonRequestDto;
import com.ejournal.journal.common.feign_client.calendar_plan.dto.CalendarPlanRequestDto;
import com.ejournal.journal.common.feign_client.calendar_plan.dto.CalendarPlanResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("calendarplan")
public interface CalendarPlanFeignClient {

    @PostMapping("/api/v1/calendarplan")
    ResponseEntity<CalendarPlanResponseDto> createCalendarPlan(@RequestBody CalendarPlanRequestDto requestDto);

    @PostMapping("/api/v1/calendarplan/{calendarPlanId}/records")
    ResponseEntity<CalendarPlanResponseDto> addCalendarPlanRecord(@PathVariable("calendarPlanId") Long calendarPlanId,
                                                                         @RequestBody CalendarLessonRequestDto calendarPlanRecordCreateRequestDto);
}
