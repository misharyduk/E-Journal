package com.ejournal.journal.journal.service;

import com.ejournal.journal.journal.dto.AcademicModuleRequestDto;
import com.ejournal.journal.journal.dto.AcademicModuleResponseDto;
import com.ejournal.journal.journal.entity.academic_entities.AcademicModule;

import java.util.List;
import java.util.Optional;

public interface AcademicModuleService {

    List<AcademicModuleResponseDto> fetchAllByJournal(Long journalId);

    AcademicModuleResponseDto fetchById(Long moduleId);

    AcademicModuleResponseDto create(AcademicModuleRequestDto module);

    boolean delete(Long moduleId);

}
