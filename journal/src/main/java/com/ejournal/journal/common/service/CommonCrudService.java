package com.ejournal.journal.common.service;

import java.util.List;

public interface CommonCrudService<K1, K2> {

    Long create(K1 requestDto);

    K2 fetchById(Long id);

    List<K2> fetchAll();

    boolean deleteById(Long id);

}
