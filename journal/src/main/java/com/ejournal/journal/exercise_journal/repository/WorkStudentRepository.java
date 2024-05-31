package com.ejournal.journal.exercise_journal.repository;

import com.ejournal.journal.exercise_journal.entity.WorkStudent;

import java.util.List;
import java.util.Optional;

public interface WorkStudentRepository {

    boolean saveWorkStudent(WorkStudent workStudent);

    Optional<WorkStudent> fetchWorkStudent(Long workStudentId);

    List<WorkStudent> fetchAllStudentsGrades();
}
