package com.ejournal.university.info.repository.impl;

import com.ejournal.university.info.entity.University;
import com.ejournal.university.info.repository.UniversityRepository;
import com.ejournal.university.teacher.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaUniversityRepositoryImpl extends JpaRepository<University, Long>, UniversityRepository {
    @Override
    default List<University> fetchAllInstances(){
        return findAll();
    }

    @Override
    default Optional<University> fetchInstanceById(Long universityId){
        return findById(universityId);
    }

    @Override
    default University createInstance(University university){
        return save(university);
    }

    @Override
    default University updateInstance(University university){
        return save(university);
    }

    @Override
    default void deleteInstance(University university){
        delete(university);
    }
}
