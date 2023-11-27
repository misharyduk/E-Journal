package com.ejournal.university.teacher.service.impl;

import com.ejournal.university.teacher.dto.TeacherRequestDto;
import com.ejournal.university.teacher.dto.TeacherResponseDto;
import com.ejournal.university.teacher.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Override
    public TeacherResponseDto create(TeacherRequestDto requestDto) {
        return null;
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
    public TeacherResponseDto update(Long id, TeacherRequestDto requestDto) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
