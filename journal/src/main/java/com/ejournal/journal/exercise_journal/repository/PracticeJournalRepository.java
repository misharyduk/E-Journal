package com.ejournal.journal.exercise_journal.repository;

import com.ejournal.journal.exercise_journal.entity.PracticeJournal;

import java.util.Optional;

public interface PracticeJournalRepository {
    Optional<PracticeJournal> fetchPracticeJournal(Long practiceJournalId);

    PracticeJournal savePracticeJournal(PracticeJournal practiceJournal);
}
