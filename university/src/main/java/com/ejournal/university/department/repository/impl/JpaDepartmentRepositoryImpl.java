package com.ejournal.university.department.repository.impl;

import com.ejournal.university.department.entity.Department;
import com.ejournal.university.department.repository.DepartmentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaDepartmentRepositoryImpl extends JpaRepository<Department, Long>, DepartmentRepository {

    @Override
    default List<Department> fetchAllInstances(){
        return findAll();
    }

    @Override
    default Optional<Department> fetchInstanceById(Long departmentId){
        return findById(departmentId);
    }

    @Override
    default Department createInstance(Department department){
        return save(department);
    }

    @Override
    default Department updateInstance(Department department){
        return save(department);
    }

    @Override
    default void deleteInstance(Department department){
        delete(department);
    }
}
