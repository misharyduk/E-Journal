package com.ejournal.group.common.repository;

import com.ejournal.group.student.entity.Student;

import java.util.List;
import java.util.Optional;

public interface CommonRepository<K> {

    List<K> fetchAllInstances();

    Optional<K> fetchInstanceById(Long id);

    K createInstance(K instance);

    K updateInstance(K instance);

    void deleteInstance(K instance);

}
