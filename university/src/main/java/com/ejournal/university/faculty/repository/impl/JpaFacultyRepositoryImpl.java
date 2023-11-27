package com.ejournal.university.faculty.repository.impl;

import com.ejournal.university.faculty.entity.Faculty;
import com.ejournal.university.faculty.repository.FacultyRepository;
import com.ejournal.university.teacher.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaFacultyRepositoryImpl extends JpaRepository<Faculty, Long>, FacultyRepository {
    @Override
    default List<Faculty> fetchAllInstances(){
        return findAll();
    }

    @Override
    default Optional<Faculty> fetchInstanceById(Long facultyId){
        return findById(facultyId);
    }

    @Override
    default Faculty createInstance(Faculty faculty){
        return save(faculty);
    }

    @Override
    default Faculty updateInstance(Faculty faculty){
        return save(faculty);
    }

    @Override
    default void deleteInstance(Faculty faculty){
        delete(faculty);
    }
}
