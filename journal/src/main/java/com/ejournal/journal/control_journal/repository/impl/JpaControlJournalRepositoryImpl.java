package com.ejournal.journal.control_journal.repository.impl;

import com.ejournal.journal.control_journal.entity.ControlJournal;
import com.ejournal.journal.control_journal.repository.ControlJournalRepository;
import com.ejournal.journal.exercise_journal.entity.PracticeJournal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaControlJournalRepositoryImpl extends JpaRepository<ControlJournal, Long>, ControlJournalRepository {
    @Override
    default Optional<ControlJournal> fetchControlJournal(Long controlJournalId){
        return findById(controlJournalId);
    }

    @Override
    default ControlJournal saveControlJournal(ControlJournal controlJournal){
        return save(controlJournal);
    }
}
