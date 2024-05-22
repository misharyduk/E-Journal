package com.ejournal.calendar_plan.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
public class CalendarLessonRequestDto {
    private Long lessonId;
    private Date lessonDate;
}
