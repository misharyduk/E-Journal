package com.ejournal.university.faculty.repository.impl;

import com.ejournal.university.department.entity.Department;
import com.ejournal.university.faculty.entity.Faculty;
import com.ejournal.university.faculty.repository.FacultyPaginationRepository;
import com.ejournal.university.faculty.repository.FacultyRepository;
import com.ejournal.university.teacher.entity.Teacher;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FacultyPaginationRepositoryImpl implements FacultyPaginationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<Faculty> fetchPage(Pageable pageable) {
        return null;
    }

    @Override
    public Page<Tuple> fetchPageOnDepartments(Pageable pageable) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createTupleQuery();

        Root<Faculty> facultyRoot = criteriaQuery.from(Faculty.class);
        Join<Faculty, Department> departmentJoin = facultyRoot.join("departments", JoinType.LEFT);

        criteriaQuery.multiselect(
                facultyRoot.get("id").alias("facultyId"),
                facultyRoot.get("facultyName").alias("facultyName"),
                facultyRoot.get("facultyDescription").alias("facultyDescription"),
                criteriaBuilder.count(departmentJoin).alias("departmentCount")
        );
        criteriaQuery.groupBy(facultyRoot);

        if(pageable.getSort().getOrderFor("departments").getDirection().isAscending()) {
            criteriaQuery.orderBy(criteriaBuilder.asc(criteriaBuilder.count(departmentJoin)));
        } else {
            criteriaQuery.orderBy(criteriaBuilder.desc(criteriaBuilder.count(departmentJoin)));
        }

        List<Tuple> result = entityManager.createQuery(criteriaQuery)
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize())
                .getResultList();

        long total = getTotalFacultyCount();

        return new PageImpl<>(result, pageable, total);
    }


    @Override
    public Page<Tuple> fetchPageOnTeachers(Pageable pageable) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> tupleQuery = criteriaBuilder.createTupleQuery();

        Root<Faculty> facultyRoot = tupleQuery.from(Faculty.class);
        Join<Faculty, Teacher> teacherJoin = facultyRoot.join("teachers", JoinType.LEFT);

        tupleQuery.multiselect(
                facultyRoot.get("id").alias("facultyId"),
                facultyRoot.get("facultyName").alias("facultyName"),
                facultyRoot.get("facultyDescription").alias("facultyDescription"),
                criteriaBuilder.count(teacherJoin).alias("teacherCount")
        );

        tupleQuery.groupBy(facultyRoot);
        if(pageable.getSort().getOrderFor("teachers").getDirection().isAscending()) {
            tupleQuery.orderBy(criteriaBuilder.asc(criteriaBuilder.count(teacherJoin)));
        } else {
            tupleQuery.orderBy(criteriaBuilder.desc(criteriaBuilder.count(teacherJoin)));
        }

        List<Tuple> result = entityManager.createQuery(tupleQuery)
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize())
                .getResultList();

        long total = getTotalFacultyCount();

        return new PageImpl<>(result, pageable, total);
    }

    private long getTotalFacultyCount() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = cb.createQuery(Long.class);
        Root<Faculty> facultyRoot = criteriaQuery.from(Faculty.class);
        criteriaQuery.select(cb.count(facultyRoot));

        return entityManager.createQuery(criteriaQuery)
                .getSingleResult();
    }
}
