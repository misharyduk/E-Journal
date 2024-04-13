package com.ejournal.journal.journal.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JournalRequestDto {
    private Long subjectId;
    private Long groupId;
    private Long teacherId;
}
