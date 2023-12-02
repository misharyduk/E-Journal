package com.ejournal.university.faculty.repository;

import com.ejournal.university.faculty.entity.Faculty;
import com.ejournal.university.faculty.repository.impl.FacultyPaginationRepositoryImpl;
import jakarta.persistence.Tuple;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FacultyPaginationRepository {

    Page<Tuple> fetchPage(Pageable pageable, String field, String direction);

    Page<Tuple> fetchPageOnDepartments(Pageable pageable);

    Page<Tuple> fetchPageOnTeachers(Pageable pageable);
}
