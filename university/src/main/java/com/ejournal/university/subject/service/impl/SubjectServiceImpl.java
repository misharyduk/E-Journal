package com.ejournal.university.subject.service.impl;

import com.ejournal.university.common.exception.ResourceNotFoundException;
import com.ejournal.university.subject.dto.SubjectRequestDto;
import com.ejournal.university.subject.dto.SubjectResponseDto;
import com.ejournal.university.subject.entity.Subject;
import com.ejournal.university.subject.mapper.SubjectMapper;
import com.ejournal.university.subject.repository.SubjectRepository;
import com.ejournal.university.subject.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Override
    public SubjectResponseDto create(SubjectRequestDto requestDto) {
        Subject subject = SubjectMapper.mapToEntity(requestDto, new Subject());
        return SubjectMapper.mapToDto(subjectRepository.createInstance(subject));
    }

    @Override
    public SubjectResponseDto fetchById(Long id) {
        Subject subject = subjectRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subject", "id", String.valueOf(id)));
        return SubjectMapper.mapToDto(subject);
    }

    @Override
    public List<SubjectResponseDto> fetchAll() {
        List<Subject> allSubjects = subjectRepository.fetchAllInstances();
        return allSubjects.stream()
                .map(SubjectMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public SubjectResponseDto update(Long id, SubjectRequestDto requestDto) {
        Subject subject = subjectRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subject", "id", String.valueOf(id)));
        Subject updatedSubject = SubjectMapper.mapToEntity(requestDto, subject);
        updatedSubject = subjectRepository.updateInstance(updatedSubject);
        return SubjectMapper.mapToDto(updatedSubject);
    }

    @Override
    public boolean deleteById(Long id) {
        Subject subject = subjectRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subject", "id", String.valueOf(id)));
        subjectRepository.deleteInstance(subject);
        return true;
    }
}
