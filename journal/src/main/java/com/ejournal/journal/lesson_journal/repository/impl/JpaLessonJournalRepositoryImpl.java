package com.ejournal.journal.lesson_journal.repository.impl;

import com.ejournal.journal.lesson_journal.entity.LessonJournal;
import com.ejournal.journal.lesson_journal.repository.LessonJournalRepository;
import com.ejournal.journal.lesson_journal.repository.LessonRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface JpaLessonJournalRepositoryImpl extends JpaRepository<LessonJournal, Long>, LessonJournalRepository {

    @Override
    default Optional<LessonJournal> fetchLessonJournal(Long lessonJournalId){
        return findByIdOrderByLessonsDateAsc(lessonJournalId);
    }

    @Override
    default LessonJournal saveLessonJournal(LessonJournal lessonJournal){
        return save(lessonJournal);
    }

    Optional<LessonJournal> findByIdOrderByLessonsDateAsc(Long lessonJournalId);
}
