package com.ejournal.university.department.repository;

import com.ejournal.university.common.repository.CommonCrudRepository;
import com.ejournal.university.department.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends CommonCrudRepository<Department> {

    Page<Department> fetchPage(Pageable pageable);

}
