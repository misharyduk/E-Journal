package com.ejournal.journal.journal.repository;

import com.ejournal.journal.journal.entity.academic_entities.AcademicModule;

import java.util.List;
import java.util.Optional;

public interface AcademicModuleRepository {

    List<AcademicModule> fetchAllModulesByJournal(Long journalId);

    List<AcademicModule> fetchAllModulesByControlJournal(Long controlJournalId);

    List<AcademicModule> fetchAllModulesByExerciseJournal(Long exerciseJournalId);

    Optional<AcademicModule> fetchModuleById(Long moduleId);

    AcademicModule createInstance(AcademicModule module);

    AcademicModule saveInstance(AcademicModule module);

    void deleteModule(AcademicModule module);
}
