package com.ejournal.journal.lesson_journal.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class LessonRequestDto {
    private String type;
    private Date date;
    private Integer order;
    private String auditory;
    private Long journalId;
}
