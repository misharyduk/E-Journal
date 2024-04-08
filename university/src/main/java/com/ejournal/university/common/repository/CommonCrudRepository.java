package com.ejournal.university.common.repository;

import java.util.List;
import java.util.Optional;

public interface CommonCrudRepository<K> {

    List<K> fetchAllInstances();

    Optional<K> fetchInstanceById(Long id);

    K createInstance(K instance);

    K updateInstance(K instance);

    void deleteInstance(K instance);

}
