package com.ejournal.journal.journal.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JournalRequestDto {
    private String semesterNumber;
    private Integer firstAcademicYear;
    private Integer secondAcademicYear;
    private Long subjectId;
    private Long groupId;
    private Long lectureTeacherId;
    private Long practicalTeacherId;
}
