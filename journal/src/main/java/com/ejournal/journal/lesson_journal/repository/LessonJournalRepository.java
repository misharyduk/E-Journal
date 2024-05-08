package com.ejournal.journal.lesson_journal.repository;

import com.ejournal.journal.exercise_journal.entity.PracticeJournal;
import com.ejournal.journal.lesson_journal.entity.LessonJournal;

import java.util.Optional;

public interface LessonJournalRepository {
    Optional<LessonJournal> fetchLessonJournal(Long lessonJournalId);

    LessonJournal saveLessonJournal(LessonJournal lessonJournal);
}
