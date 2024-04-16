package com.ejournal.journal.journal.dto;

import com.ejournal.journal.journal.entity.academic_entities.AcademicModule;
import com.ejournal.journal.journal.entity.academic_entities.ExerciseWorkType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ExerciseWorkResponseDto {
    private Long id;
    private Integer workNumber;
    private String lessonType;
    private AcademicModuleResponseDto academicModule;

    public ExerciseWorkResponseDto(Long id, Integer workNumber, String lessonType) {
        this.id = id;
        this.workNumber = workNumber;
        this.lessonType = lessonType;
    }
}
