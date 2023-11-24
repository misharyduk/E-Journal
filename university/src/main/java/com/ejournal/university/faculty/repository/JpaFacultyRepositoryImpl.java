package com.ejournal.university.faculty.repository;

import com.ejournal.university.faculty.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaFacultyRepositoryImpl extends JpaRepository<Faculty, Long> {
}
