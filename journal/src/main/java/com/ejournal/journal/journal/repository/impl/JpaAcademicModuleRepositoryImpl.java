package com.ejournal.journal.journal.repository.impl;

import com.ejournal.journal.journal.entity.academic_entities.AcademicModule;
import com.ejournal.journal.journal.repository.AcademicModuleRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaAcademicModuleRepositoryImpl extends JpaRepository<AcademicModule, Long>, AcademicModuleRepository {

    @Override
    default List<AcademicModule> fetchAllModulesByJournal(Long journalId){
        return findAllByJournalId(journalId);
    }

    @Override
    default List<AcademicModule> fetchAllModulesByControlJournal(Long controlJournalId){
        return findAllByJournalControlJournalId(controlJournalId);
    }

    @Override
    default List<AcademicModule> fetchAllModulesByExerciseJournal(Long exerciseJournalId){
        return findAllByJournalExerciseWorkJournalId(exerciseJournalId);
    }

    @Override
    default Optional<AcademicModule> fetchModuleById(Long moduleId){
        return findById(moduleId);
    }

    @Override
    default AcademicModule createInstance(AcademicModule module){
        return save(module);
    }

    @Override
    default AcademicModule saveInstance(AcademicModule module){
        return save(module);
    }

    @Override
    default void deleteModule(AcademicModule module){

    }

    List<AcademicModule> findAllByJournalId(Long journalId);

    List<AcademicModule> findAllByJournalControlJournalId(Long controlJournalId);

    List<AcademicModule> findAllByJournalExerciseWorkJournalId(Long exerciseJournalId);
}
