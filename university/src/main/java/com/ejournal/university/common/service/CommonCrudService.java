package com.ejournal.university.common.service;

import com.ejournal.university.info.dto.UniversityRequestDto;
import com.ejournal.university.info.dto.UniversityResponseDto;

import java.util.List;

public interface CommonCrudService<K1, K2> {

    K2 create(K1 requestDto);

    K2 fetchById(Long id);

    List<K2> fetchAll();

    K2 update(K1 requestDto);

    boolean deleteById(Long id);

}
