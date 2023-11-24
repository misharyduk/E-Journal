package com.ejournal.university.subject.service.impl;

import com.ejournal.university.subject.dto.SubjectRequestDto;
import com.ejournal.university.subject.dto.SubjectResponseDto;
import com.ejournal.university.subject.service.SubjectService;

import java.util.List;

public class SubjectServiceImpl implements SubjectService {
    @Override
    public boolean create(SubjectRequestDto requestDto) {
        return false;
    }

    @Override
    public SubjectResponseDto fetchById(Long id) {
        return null;
    }

    @Override
    public List<SubjectResponseDto> fetchAll() {
        return null;
    }

    @Override
    public SubjectResponseDto update(SubjectRequestDto requestDto) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
