package com.ejournal.journal.journal.repository.impl;

import com.ejournal.journal.journal.entity.Journal;
import com.ejournal.journal.journal.repository.JournalRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaJournalRepositoryImpl extends JpaRepository<Journal, Long>, JournalRepository {

    @Override
    default List<Journal> fetchAllInstances(){
        return findAll();
    }

    @Override
    default Optional<Journal> fetchInstanceById(Long journalId){
        return findById(journalId);
    }

    @Override
    default Journal createInstance(Journal journal){
        return save(journal);
    }

    @Override
    default Journal updateInstance(Journal journal){
        return save(journal);
    }

    @Override
    default void deleteInstance(Journal journal){
        delete(journal);
    }

}
