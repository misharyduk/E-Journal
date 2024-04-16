package com.ejournal.journal.lesson_journal.repository;

import jakarta.persistence.Tuple;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LessonPaginationRepository {

    Page<Tuple> fetchPage(Long journalId, Pageable pageable, String field, String direction);

}
