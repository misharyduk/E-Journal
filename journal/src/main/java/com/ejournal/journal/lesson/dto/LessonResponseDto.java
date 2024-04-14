package com.ejournal.journal.lesson.dto;

import com.ejournal.journal.journal.dto.JournalResponseDto;
import com.ejournal.journal.journal.entity.Journal;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class LessonResponseDto {
    private Long id;
    private String type;
    private Date date;
    private Integer order;
    private String auditory;
    private Long journalId;
}
