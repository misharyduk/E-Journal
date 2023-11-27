package com.ejournal.university.department.repository;

import com.ejournal.university.department.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository {
    List<Department> findAllDepartments();

    Optional<Department> findDepartmentById(Long departmentId);

    Department createDepartment(Department department);

    Department updateDepartment(Department department);

    void deleteDepartment(Department department);
}
