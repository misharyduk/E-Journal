package com.ejournal.journal.common.service;

import com.ejournal.journal.common.dto.PageableRequestDto;
import com.ejournal.journal.common.dto.PageableResponseDto;
import com.ejournal.journal.lesson.dto.LessonRequestDto;
import com.ejournal.journal.lesson.dto.LessonResponseDto;

import java.util.List;

public interface CommonCrudService<K1, K2> {

    K2 create(K1 requestDto);

    K2 fetchById(Long id);

    boolean deleteById(Long id);

}
