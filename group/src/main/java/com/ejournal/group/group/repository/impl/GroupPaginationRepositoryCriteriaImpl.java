package com.ejournal.group.group.repository.impl;

import com.ejournal.group.group.entity.Group;
import com.ejournal.group.group.repository.GroupPaginationRepository;
import com.ejournal.group.group.repository.GroupRepository;
import com.ejournal.group.student.entity.Student;
import com.ejournal.group.student.service.StudentService;
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
public class GroupPaginationRepositoryCriteriaImpl implements GroupPaginationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<Tuple> fetchPage(Pageable pageable, String field, String direction) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteriaQuery = cb.createTupleQuery();
        Root<Group> groupRoot = criteriaQuery.from(Group.class);

        Join<Group, Student> studentJoin = groupRoot.join("students", JoinType.LEFT);

        criteriaQuery.multiselect(
                groupRoot.get("id").alias("groupId"),
                groupRoot.get("groupNumber").alias("groupNumber"), // TODO fix this - names is equals
                cb.count(studentJoin).alias("studentsCount")
        );
        criteriaQuery.groupBy(groupRoot);

        if(field.equals("students")) {
            if (pageable.getSort().getOrderFor("students").getDirection().isAscending()) {
                criteriaQuery.orderBy(cb.asc(cb.count(studentJoin)));
            } else {
                criteriaQuery.orderBy(cb.desc(cb.count(studentJoin)));
            }
        } else {
            if (direction.equalsIgnoreCase("desc")) {
                criteriaQuery.orderBy(cb.desc(groupRoot.get(field)));
            } else {
                criteriaQuery.orderBy(cb.asc(groupRoot.get(field)));
            }
        }

        List<Tuple> result = entityManager.createQuery(criteriaQuery)
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize())
                .getResultList();

        long total = getTotalGroupCount();

        return new PageImpl<>(result, pageable, total);
    }

    private long getTotalGroupCount(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<Group> groupRoot = query.from(Group.class);

        query.select(cb.count(groupRoot));

        return entityManager.createQuery(query).getSingleResult();
    }
}
