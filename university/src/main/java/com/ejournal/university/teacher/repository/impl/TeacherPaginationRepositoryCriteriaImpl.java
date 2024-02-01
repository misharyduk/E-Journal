package com.ejournal.university.teacher.repository.impl;

import com.ejournal.university.teacher.entity.Teacher;
import com.ejournal.university.teacher.repository.TeacherPaginationRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherPaginationRepositoryCriteriaImpl implements TeacherPaginationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<Tuple> fetchPage(Pageable pageable, String field, String direction) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteriaQuery = cb.createTupleQuery();
        Root<Teacher> teacherRoot = criteriaQuery.from(Teacher.class);

        criteriaQuery.multiselect(
                teacherRoot.get("teacher_id").alias("teacherId"),
                teacherRoot.get("first_name").alias("firstName"),
                teacherRoot.get("last_name").alias("lastName"),
                teacherRoot.get("middle_name").alias("middleName"),
                teacherRoot.get("email").alias("email")
        );

        if(direction.equals("desc")){
            criteriaQuery.orderBy(cb.desc(teacherRoot.get(field)));
        } else {
            criteriaQuery.orderBy(cb.asc(teacherRoot.get(field)));
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
        Root<Teacher> teacherRoot = query.from(Teacher.class);
        query.select(cb.count(teacherRoot));

        return entityManager.createQuery(query).getSingleResult();
    }
}
