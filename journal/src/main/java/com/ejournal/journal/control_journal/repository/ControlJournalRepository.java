package com.ejournal.journal.control_journal.repository;

import com.ejournal.journal.control_journal.entity.ControlJournal;
import com.ejournal.journal.exercise_journal.entity.PracticeJournal;

import java.util.Optional;

public interface ControlJournalRepository {
    Optional<ControlJournal> fetchControlJournal(Long controlJournalId);

    ControlJournal saveControlJournal(ControlJournal controlJournalId);
}
