package com.ejournal.journal.exercise_journal.repository.impl;

import com.ejournal.journal.exercise_journal.repository.PracticeJournalRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPracticeJournalRepositoryImpl extends JpaRepository<PracticeJournal, Long>, PracticeJournalRepository {
}
