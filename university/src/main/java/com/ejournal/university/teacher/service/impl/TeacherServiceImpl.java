package com.ejournal.university.teacher.service.impl;

import com.ejournal.university.teacher.dto.TeacherRequestDto;
import com.ejournal.university.teacher.dto.TeacherResponseDto;
import com.ejournal.university.teacher.service.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    @Override
    public boolean create(TeacherRequestDto requestDto) {
        return false;
    }

    @Override
    public TeacherResponseDto fetchById(Long id) {
        return null;
    }

    @Override
    public List<TeacherResponseDto> fetchAll() {
        return null;
    }

    @Override
    public TeacherResponseDto update(TeacherRequestDto requestDto) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
