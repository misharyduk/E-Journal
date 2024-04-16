package com.ejournal.journal.journal.repository;

import com.ejournal.journal.journal.entity.academic_entities.AcademicModule;
import com.ejournal.journal.journal.entity.academic_entities.ExerciseWork;

import java.util.List;
import java.util.Optional;

public interface ExerciseWorkRepository {

    List<ExerciseWork> fetchAllExerciseWorkByJournal(Long journalId);

    Optional<ExerciseWork> fetchExerciseWorkById(Long exerciseWorkId);

    ExerciseWork createInstance(ExerciseWork exerciseWork);

    void deleteExerciseWork(ExerciseWork exerciseWork);

}
