package com.ejournal.university.department.repository;

import com.ejournal.university.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaDepartmentRepositoryImpl extends JpaRepository<Department, Long> {
}
