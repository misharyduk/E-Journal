package com.ejournal.university.teacher.repository.impl;

import com.ejournal.university.teacher.entity.Teacher;
import com.ejournal.university.teacher.repository.TeacherRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaTeacherRepositoryImpl extends JpaRepository<Teacher, Long>, TeacherRepository {
    @Override
    default List<Teacher> fetchAllInstances(){
        return findAll();
    }

    @Override
    default Optional<Teacher> fetchInstanceById(Long teacherId){
        return findById(teacherId);
    }

    @Override
    default Teacher createInstance(Teacher teacher){
        return save(teacher);
    }

    @Override
    default Teacher updateInstance(Teacher teacher){
        return save(teacher);
    }

    @Override
    default void deleteInstance(Teacher teacher){
        delete(teacher);
    }
}
