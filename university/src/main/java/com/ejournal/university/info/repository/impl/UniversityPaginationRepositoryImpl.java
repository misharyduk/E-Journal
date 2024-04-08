package com.ejournal.university.info.repository.impl;

import com.ejournal.university.department.entity.Department;
import com.ejournal.university.faculty.entity.Faculty;
import com.ejournal.university.info.entity.University;
import com.ejournal.university.info.repository.UniversityPaginationRepository;
import com.ejournal.university.teacher.entity.Teacher;
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
public class UniversityPaginationRepositoryImpl implements UniversityPaginationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<Tuple> fetchPage(Pageable pageable, String field, String direction) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createTupleQuery();
        Root<University> universityRoot = query.from(University.class);

        query.multiselect(
                universityRoot.get("id").alias("universityId"),
                universityRoot.get("universityName").alias("universityName"),
                universityRoot.get("universityDescription").alias("universityDescription")
        );

        if(direction.equals("desc")){
            query.orderBy(criteriaBuilder.desc(universityRoot.get(field)));
        } else{
            query.orderBy(criteriaBuilder.asc(universityRoot.get(field)));
        }

        List<Tuple> result = entityManager.createQuery(query)
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize())
                .getResultList();

        long total = getTotalUniversityCount();

        return new PageImpl<>(result, pageable, total);
    }

    @Override
    public Page<Tuple> fetchPageOnDepartments(Pageable pageable) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createTupleQuery();
        Root<University> universityRoot = query.from(University.class);

        Join<University, Faculty> facultyJoin = universityRoot.join("faculties", JoinType.LEFT);
        Join<Faculty, Department> departmentJoin = facultyJoin.join("departments", JoinType.LEFT);

        query.multiselect(
                universityRoot.get("id").alias("universityId"),
                universityRoot.get("universityName").alias("universityName"),
                universityRoot.get("universityDescription").alias("universityDescription"),
                criteriaBuilder.count(departmentJoin).alias("departmentCount")
        );

        query.groupBy(universityRoot);

        if(pageable.getSort().getOrderFor("departments").getDirection().isDescending()){
            query.orderBy(criteriaBuilder.desc(criteriaBuilder.count(departmentJoin)));
        } else{
            query.orderBy(criteriaBuilder.asc(criteriaBuilder.count(departmentJoin)));
        }

        List<Tuple> result = entityManager.createQuery(query)
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize())
                .getResultList();

        long total = getTotalUniversityCount();

        return new PageImpl<>(result, pageable, total);
    }

    @Override
    public Page<Tuple> fetchPageOnFaculties(Pageable pageable) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createTupleQuery();
        Root<University> universityRoot = query.from(University.class);

        Join<University, Faculty> facultyJoin = universityRoot.join("faculties", JoinType.LEFT);

        query.multiselect(
                universityRoot.get("id").alias("universityId"),
                universityRoot.get("universityName").alias("universityName"),
                universityRoot.get("universityDescription").alias("universityDescription"),
                criteriaBuilder.count(facultyJoin).alias("facultyCount")
        );

        query.groupBy(universityRoot);

        if(pageable.getSort().getOrderFor("faculties").getDirection().isDescending()){
            query.orderBy(criteriaBuilder.desc(criteriaBuilder.count(facultyJoin)));
        } else{
            query.orderBy(criteriaBuilder.asc(criteriaBuilder.count(facultyJoin)));
        }

        List<Tuple> result = entityManager.createQuery(query)
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize())
                .getResultList();

        long total = getTotalUniversityCount();

        return new PageImpl<>(result, pageable, total);
    }

    @Override
    public Page<Tuple> fetchPageOnTeachers(Pageable pageable) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createTupleQuery();
        Root<University> universityRoot = query.from(University.class);

        Join<University, Faculty> facultyJoin = universityRoot.join("faculties", JoinType.LEFT);
        Join<Faculty, Teacher> teacherJoin = facultyJoin.join("teachers", JoinType.LEFT);

        query.multiselect(
                universityRoot.get("id").alias("universityId"),
                universityRoot.get("universityName").alias("universityName"),
                universityRoot.get("universityDescription").alias("universityDescription"),
                criteriaBuilder.count(teacherJoin).alias("teacherCount")
        );

        query.groupBy(universityRoot);

        if(pageable.getSort().getOrderFor("teachers").getDirection().isDescending()){
            query.orderBy(criteriaBuilder.desc(criteriaBuilder.count(teacherJoin)));
        } else{
            query.orderBy(criteriaBuilder.asc(criteriaBuilder.count(teacherJoin)));
        }

        List<Tuple> result = entityManager.createQuery(query)
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize())
                .getResultList();

        long total = getTotalUniversityCount();

        return new PageImpl<>(result, pageable, total);
    }

    long getTotalUniversityCount(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);
        Root<University> universityRoot = query.from(University.class);
        query.select(criteriaBuilder.count(universityRoot));

        return entityManager.createQuery(query).getSingleResult();
    }
}
