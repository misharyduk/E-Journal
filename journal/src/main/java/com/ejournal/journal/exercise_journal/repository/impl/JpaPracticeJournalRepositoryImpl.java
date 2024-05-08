package com.ejournal.journal.exercise_journal.repository.impl;

import com.ejournal.journal.exercise_journal.entity.PracticeJournal;
import com.ejournal.journal.exercise_journal.repository.PracticeJournalRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaPracticeJournalRepositoryImpl extends JpaRepository<PracticeJournal, Long>, PracticeJournalRepository {
    @Override
    default Optional<PracticeJournal> fetchPracticeJournal(Long practiceJournalId){
        return findById(practiceJournalId);
    }

    @Override
    default PracticeJournal savePracticeJournal(PracticeJournal practiceJournal){
        return save(practiceJournal);
    }
}
