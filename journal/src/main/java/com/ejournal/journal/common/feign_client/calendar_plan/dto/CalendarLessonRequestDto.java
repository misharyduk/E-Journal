package com.ejournal.journal.common.feign_client.calendar_plan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class CalendarLessonRequestDto {
    private Long lessonId;
    private Date lessonDate;
}
