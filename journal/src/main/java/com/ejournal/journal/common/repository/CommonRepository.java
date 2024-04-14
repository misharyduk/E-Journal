package com.ejournal.journal.common.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CommonRepository<K> {

    List<K> fetchAllInstances();

    Optional<K> fetchInstanceById(Long id);

    Page<K> fetchPage(Pageable pageable);

    K createInstance(K instance);

    K updateInstance(K instance);

    void deleteInstance(K instance);

}
