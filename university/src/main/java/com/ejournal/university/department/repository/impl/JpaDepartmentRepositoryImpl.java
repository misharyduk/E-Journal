package com.ejournal.university.department.repository.impl;

import com.ejournal.university.department.entity.Department;
import com.ejournal.university.department.repository.DepartmentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaDepartmentRepositoryImpl extends JpaRepository<Department, Long>, DepartmentRepository {
}
