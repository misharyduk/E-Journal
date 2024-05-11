package com.ejournal.journal.journal.service.impl;

import com.ejournal.journal.common.exception.ResourceNotFoundException;
import com.ejournal.journal.journal.dto.AcademicModuleRequestDto;
import com.ejournal.journal.journal.dto.AcademicModuleResponseDto;
import com.ejournal.journal.journal.dto.ExerciseWorkRequestDto;
import com.ejournal.journal.journal.dto.ExerciseWorkResponseDto;
import com.ejournal.journal.journal.entity.Journal;
import com.ejournal.journal.journal.entity.academic_entities.AcademicModule;
import com.ejournal.journal.journal.entity.academic_entities.ExerciseWork;
import com.ejournal.journal.journal.entity.academic_entities.ExerciseWorkType;
import com.ejournal.journal.journal.mapper.AcademicModuleMapper;
import com.ejournal.journal.journal.mapper.ExerciseWorkMapper;
import com.ejournal.journal.journal.repository.AcademicModuleRepository;
import com.ejournal.journal.journal.repository.ExerciseWorkRepository;
import com.ejournal.journal.journal.repository.JournalRepository;
import com.ejournal.journal.journal.service.AcademicModuleService;
import com.ejournal.journal.journal.service.ExerciseWorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseWorkServiceImpl implements ExerciseWorkService {

    private final ExerciseWorkRepository exerciseWorkRepository;
    private final AcademicModuleRepository academicModuleRepository;

    @Override
    public List<ExerciseWorkResponseDto> fetchAllByJournal(Long journalId) {
        return exerciseWorkRepository.fetchAllExerciseWorkByJournal(journalId)
                .stream()
                .map(this::fillExerciseWorkResponseDto)
                .toList();
    }

    @Override
    public ExerciseWorkResponseDto fetchById(Long exerciseWorkId) {
        ExerciseWork exerciseWork = exerciseWorkRepository.fetchExerciseWorkById(exerciseWorkId)
                .orElseThrow(() -> new ResourceNotFoundException("Exercise Work", "id", String.valueOf(exerciseWorkId)));
        return fillExerciseWorkResponseDto(exerciseWork);
    }

    @Override
    public boolean delete(Long exerciseWorkId) {

        ExerciseWork exerciseWork = exerciseWorkRepository.fetchExerciseWorkById(exerciseWorkId)
                .orElseThrow(() -> new ResourceNotFoundException("Exercise Work", "id", String.valueOf(exerciseWorkId)));

        exerciseWorkRepository.deleteExerciseWork(exerciseWork);

        return true;
    }

    private ExerciseWorkResponseDto fillExerciseWorkResponseDto(ExerciseWork exerciseWork){
        ExerciseWorkResponseDto responseDto = ExerciseWorkMapper.mapToDto(exerciseWork);
        responseDto.setAcademicModule(AcademicModuleMapper.mapToDto(exerciseWork.getAcademicModule()));
        return responseDto;
    }
}
