package com.ejournal.journal.common.service;

public interface CommonCrudService<K1, K2> {

    K2 create(K1 requestDto);

    K2 fetchById(Long id);

    boolean deleteById(Long id);

}
