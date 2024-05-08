package com.ejournal.journal.exercise_journal.dto;

import com.ejournal.journal.exercise_journal.entity.WorkStudent;
import com.ejournal.journal.journal.dto.ExerciseWorkResponseDto;
import com.ejournal.journal.journal.entity.academic_entities.ExerciseWork;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data @Builder
public class PracticeJournalResponseDto {

    private Long id;
    private List<ExerciseWorkResponseDto> exerciseWorks;

}
