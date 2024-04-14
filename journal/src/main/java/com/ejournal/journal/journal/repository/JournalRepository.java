package com.ejournal.journal.journal.repository;

import com.ejournal.journal.common.repository.CommonRepository;
import com.ejournal.journal.journal.entity.Journal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JournalRepository extends CommonRepository<Journal> {

    List<Journal> fetchAllInstancesBySubject(Long subjectId);

    List<Journal> fetchAllInstancesByTeacher(Long teacherId);

    List<Journal> fetchAllInstancesByGroup(Long groupId);

}
