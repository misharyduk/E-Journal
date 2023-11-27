package com.ejournal.university.subject.repository.impl;

import com.ejournal.university.subject.entity.Subject;
import com.ejournal.university.subject.repository.SubjectRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaSubjectRepositoryImpl extends JpaRepository<Subject, Long>, SubjectRepository {

    @Override
    default List<Subject> fetchAllInstances(){
        return findAll();
    }

    @Override
    default Optional<Subject> fetchInstanceById(Long subjectId){
        return findById(subjectId);
    }

    @Override
    default Subject createInstance(Subject subject){
        return save(subject);
    }

    @Override
    default Subject updateInstance(Subject subject){
        return save(subject);
    }

    @Override
    default void deleteInstance(Subject subject){
        delete(subject);
    }

}
