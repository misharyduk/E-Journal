package com.ejournal.journal.common.service;

import java.util.List;

public interface CommonCrudService<K1, K2> {

    K2 create(K1 requestDto);

    K2 fetchById(Long id);

    List<K2> fetchAll();

    K2 update(Long id, K1 requestDto);

    boolean deleteById(Long id);

}
