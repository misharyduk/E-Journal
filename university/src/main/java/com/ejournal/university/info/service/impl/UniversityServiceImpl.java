package com.ejournal.university.info.service.impl;

import com.ejournal.university.common.dto.AddressDto;
import com.ejournal.university.common.exception.ResourceNotFoundException;
import com.ejournal.university.info.dto.UniversityResponseDto;
import com.ejournal.university.info.dto.UniversityRequestDto;
import com.ejournal.university.info.entity.University;
import com.ejournal.university.info.mapper.UniversityMapper;
import com.ejournal.university.info.repository.UniversityRepository;
import com.ejournal.university.info.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository universityRepository;

    @Override
    public UniversityResponseDto create(UniversityRequestDto requestDto) {
        University university = UniversityMapper.mapToEntity(requestDto, new University());
        universityRepository.createInstance(university);
        return UniversityMapper.mapToDto(university);
    }

    @Override
    public UniversityResponseDto fetchById(Long id) {
        University university = universityRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("University", "id", String.valueOf(id)));
        return UniversityMapper.mapToDto(university);
    }

    @Override
    public List<UniversityResponseDto> fetchAll() {
        List<University> allUniversities = universityRepository.fetchAllInstances();
        return allUniversities.stream()
                .map(UniversityMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UniversityResponseDto update(Long id, UniversityRequestDto requestDto) {
        University university = universityRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("University", "id", String.valueOf(id)));
        University updatedUniversity = UniversityMapper.mapToEntity(requestDto, university);
        updatedUniversity = universityRepository.updateInstance(updatedUniversity);
        return UniversityMapper.mapToDto(updatedUniversity);
    }

    @Override
    public boolean deleteById(Long id) {
        University university = universityRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("University", "id", String.valueOf(id)));
        universityRepository.deleteInstance(university);
        return true;
    }
}
