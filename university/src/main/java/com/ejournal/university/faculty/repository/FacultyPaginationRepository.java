package com.ejournal.university.faculty.repository;

import jakarta.persistence.Tuple;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FacultyPaginationRepository {

    Page<Tuple> fetchPage(Pageable pageable, String field, String direction);

    Page<Tuple> fetchPageOnDepartments(Pageable pageable);

    Page<Tuple> fetchPageOnTeachers(Pageable pageable);
}
