package com.ejournal.journal.journal.repository.impl;

import com.ejournal.journal.journal.entity.Journal;
import com.ejournal.journal.journal.repository.JournalRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JpaJournalRepositoryImpl extends JpaRepository<Journal, Long>, JournalRepository {

    @Override
    default List<Journal> fetchAllInstances(){
        return findAll();
    }

    @Override
    default Optional<Journal> fetchInstanceById(Long journalId){
        return findById(journalId);
    }

    @Override
    default Page<Journal> fetchPage(Pageable pageable){
        return findAll(pageable);
    }

    @Override
    default List<Journal> fetchAllInstancesBySubject(Long subjectId){
        return findAllBySubjectId(subjectId);
    }

    @Override
    default List<Journal> fetchAllInstancesByTeacher(Long teacherId){
        return findAllByLectureTeacherIdOrPracticalTeacherId(teacherId);
    }

    @Override
    default List<Journal> fetchAllInstancesByGroup(Long groupId){
        return findAllByGroupId(groupId);
    }

    @Override
    default Journal createInstance(Journal journal){
        return save(journal);
    }

    @Override
    default Journal updateInstance(Journal journal){
        return save(journal);
    }

    @Override
    default void deleteInstance(Journal journal){
        delete(journal);
    }

    List<Journal> findAllBySubjectId(Long subjectId);

    @Query("from Journal where lectureTeacherId=?1 OR practicalTeacherId=?1")
    List<Journal> findAllByLectureTeacherIdOrPracticalTeacherId(Long teacherId);

    List<Journal> findAllByGroupId(Long groupId);
}
