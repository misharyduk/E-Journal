package com.ejournal.journal.lesson_journal.repository.impl;

import com.ejournal.journal.lesson_journal.entity.Lesson;
import com.ejournal.journal.lesson_journal.repository.LessonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JpaLessonRepositoryImpl extends JpaRepository<Lesson, Long>, LessonRepository {
    @Override
    default List<Lesson> fetchAllInstances(){
        return findAll();
    }

    @Override
    default Optional<Lesson> fetchInstanceById(Long lessonId){
        return findById(lessonId);
    }

    @Override
    default Page<Lesson> fetchPage(Pageable pageable){
        return findAll(pageable);
    }

    @Override
    default Lesson createInstance(Lesson lesson){
        return save(lesson);
    }

    @Override
    default Lesson updateInstance(Lesson lesson){
        return save(lesson);
    }

    @Override
    default void deleteInstance(Lesson lesson){
        delete(lesson);
    }

}
