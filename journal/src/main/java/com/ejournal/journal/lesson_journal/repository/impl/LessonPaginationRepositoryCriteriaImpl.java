package com.ejournal.journal.lesson_journal.repository.impl;

import com.ejournal.journal.lesson_journal.entity.Lesson;
import com.ejournal.journal.lesson_journal.repository.LessonPaginationRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LessonPaginationRepositoryCriteriaImpl implements LessonPaginationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<Tuple> fetchPage(Long journalId, Pageable pageable, String field, String direction) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteriaQuery = cb.createTupleQuery();
        Root<Lesson> lessonRoot = criteriaQuery.from(Lesson.class);

        criteriaQuery.where(cb.equal(lessonRoot.get("journal").get("id"), journalId));

        if(direction.equals("desc")){
            criteriaQuery.orderBy(cb.desc(lessonRoot.get(field)));
        } else {
            criteriaQuery.orderBy(cb.asc(lessonRoot.get(field)));
        }

        List<Tuple> result = entityManager.createQuery(criteriaQuery)
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize())
                .getResultList();

        long total = getTotalTeacherCount();

        return new PageImpl<>(result, pageable, total);
    }

    private long getTotalTeacherCount(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<Lesson> lessonRoot = query.from(Lesson.class);
        query.select(cb.count(lessonRoot));

        return entityManager.createQuery(query).getSingleResult();
    }
}
