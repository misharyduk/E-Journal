package com.ejournal.university.subject.repository;

import com.ejournal.university.subject.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSubjectRepositoryImpl extends JpaRepository<Subject, Long> {
}
