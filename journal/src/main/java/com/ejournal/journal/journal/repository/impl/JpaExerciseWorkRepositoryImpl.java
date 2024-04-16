package com.ejournal.journal.journal.repository.impl;

import com.ejournal.journal.journal.entity.academic_entities.AcademicModule;
import com.ejournal.journal.journal.entity.academic_entities.ExerciseWork;
import com.ejournal.journal.journal.repository.AcademicModuleRepository;
import com.ejournal.journal.journal.repository.ExerciseWorkRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaExerciseWorkRepositoryImpl extends JpaRepository<ExerciseWork, Long>, ExerciseWorkRepository {

    @Override
    default List<ExerciseWork> fetchAllExerciseWorkByJournal(Long journalId){
        return findAllByAcademicModuleJournalId(journalId);
    }

    @Override
    default Optional<ExerciseWork> fetchExerciseWorkById(Long exerciseWorkId){
        return findById(exerciseWorkId);
    }

    @Override
    default ExerciseWork createInstance(ExerciseWork exerciseWork){
        return save(exerciseWork);
    }

    @Override
    default void deleteExerciseWork(ExerciseWork exerciseWork){
        delete(exerciseWork);
    }

    List<ExerciseWork> findAllByAcademicModuleJournalId(Long journalId);
}
