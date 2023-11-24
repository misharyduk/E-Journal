package com.ejournal.university.teacher.repository;

import com.ejournal.university.teacher.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTeacherRepositoryImpl extends JpaRepository<Teacher, Long> {
}
