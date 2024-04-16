package com.ejournal.journal.journal.service;

import com.ejournal.journal.journal.dto.AcademicModuleRequestDto;
import com.ejournal.journal.journal.dto.AcademicModuleResponseDto;
import com.ejournal.journal.journal.dto.ExerciseWorkRequestDto;
import com.ejournal.journal.journal.dto.ExerciseWorkResponseDto;

import java.util.List;

public interface ExerciseWorkService {

    List<ExerciseWorkResponseDto> fetchAllByJournal(Long journalId);

    ExerciseWorkResponseDto fetchById(Long exerciseWorkId);

    ExerciseWorkResponseDto create(ExerciseWorkRequestDto exerciseWorkRequestDto);

    boolean delete(Long exerciseWorkId);

}
