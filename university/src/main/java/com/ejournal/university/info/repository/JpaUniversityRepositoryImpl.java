package com.ejournal.university.info.repository;

import com.ejournal.university.info.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUniversityRepositoryImpl extends JpaRepository<University, Long> {
}
