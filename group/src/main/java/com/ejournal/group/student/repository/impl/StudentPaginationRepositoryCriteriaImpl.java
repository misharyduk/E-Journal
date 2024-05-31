package com.ejournal.group.student.repository.impl;

import com.ejournal.group.group.entity.Group;
import com.ejournal.group.student.entity.Student;
import com.ejournal.group.student.repository.StudentPaginationRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentPaginationRepositoryCriteriaImpl implements StudentPaginationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<Tuple> fetchPage(Pageable pageable, String field, String direction) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteriaQuery = cb.createTupleQuery();
        Root<Student> studentRoot = criteriaQuery.from(Student.class);

        Join<Student, Group> groupJoin = studentRoot.join("group", JoinType.LEFT);

        criteriaQuery.multiselect(
                studentRoot.get("id").alias("studentId"),
                studentRoot.get("firstName").alias("firstName"),
                studentRoot.get("lastName").alias("lastName"),
                studentRoot.get("middleName").alias("middleName"),
                studentRoot.get("mobilePhone").alias("mobilePhone"),
                studentRoot.get("email").alias("email"),
                groupJoin.get("id").alias("groupId")
        );

        if(direction.equals("desc")){
            criteriaQuery.orderBy(cb.desc(studentRoot.get(field)));
        } else {
            criteriaQuery.orderBy(cb.asc(studentRoot.get(field)));
        }

        List<Tuple> result = entityManager.createQuery(criteriaQuery)
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize())
                .getResultList();

        long total = getTotalStudentCount();

        return new PageImpl<>(result, pageable, total);
    }

    private long getTotalStudentCount(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = cb.createQuery(Long.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);
        criteriaQuery.select(cb.count(studentRoot));

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
}
