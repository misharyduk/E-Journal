package com.ejournal.journal.exercise_journal.repository.impl;

import com.ejournal.journal.exercise_journal.entity.WorkStudent;
import com.ejournal.journal.exercise_journal.repository.WorkStudentRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaWorkStudentRepositoryImpl extends JpaRepository<WorkStudent, Long>, WorkStudentRepository {

    @Override
    default boolean saveWorkStudent(WorkStudent workStudent){
        save(workStudent);
        return true;
    }

    @Override
    default Optional<WorkStudent> fetchWorkStudent(Long workStudentId){
        return findById(workStudentId);
    }
}
