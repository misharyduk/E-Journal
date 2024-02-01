package com.ejournal.university.teacher.repository;

import jakarta.persistence.Tuple;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeacherPaginationRepository {

    Page<Tuple> fetchPage(Pageable pageable, String field, String direction);

}
