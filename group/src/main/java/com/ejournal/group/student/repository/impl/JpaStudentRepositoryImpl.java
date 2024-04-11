package com.ejournal.group.student.repository.impl;

import com.ejournal.group.student.entity.Student;
import com.ejournal.group.student.repository.StudentRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaStudentRepositoryImpl extends JpaRepository<Student, Long>, StudentRepository {

    @Override
    default List<Student> fetchAllInstances(){
        return findAll();
    }

    @Override
    default Optional<Student> fetchInstanceById(Long studentId){
        return findById(studentId);
    }

    @Override
    default List<Student> fetchStudentsByGroupId(Long groupId) {
        return findStudentsByGroupId(groupId);
    }

    @Override
    default Long countStudentByGroupId(Long groupId){
        return countByGroupId(groupId);
    }

    @Override
    default Student createInstance(Student student){
        return save(student);
    }

    @Override
    default Student updateInstance(Student student){
        return save(student);
    }

    @Override
    default void deleteInstance(Student student){
        delete(student);
    }

    List<Student> findStudentsByGroupId(Long id);

    Long countByGroupId(Long groupId);
}
