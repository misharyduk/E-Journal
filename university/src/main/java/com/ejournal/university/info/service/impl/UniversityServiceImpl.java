package com.ejournal.university.info.service.impl;

import com.ejournal.university.common.dto.PageableRequestDto;
import com.ejournal.university.common.dto.PageableResponseDto;
import com.ejournal.university.common.exception.ResourceNotFoundException;
import com.ejournal.university.info.dto.UniversityResponseDto;
import com.ejournal.university.info.dto.UniversityRequestDto;
import com.ejournal.university.info.entity.University;
import com.ejournal.university.info.mapper.UniversityMapper;
import com.ejournal.university.info.repository.UniversityRepository;
import com.ejournal.university.info.service.UniversityService;
import com.ejournal.university.teacher.entity.Teacher;
import com.ejournal.university.teacher.mapper.TeacherMapper;
import com.ejournal.university.teacher.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository universityRepository;
    private final TeacherRepository teacherRepository;

    private final UniversityPaginationService paginationService;

    @Override
    public UniversityResponseDto create(UniversityRequestDto requestDto) {
        University university = UniversityMapper.mapToEntity(requestDto, new University());
        university.setRector(TeacherMapper.mapToEntity(requestDto.getRector(), new Teacher()));
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
    public PageableResponseDto<UniversityResponseDto> fetchPage(PageableRequestDto pageableRequestDto) {
        PageableResponseDto<UniversityResponseDto> page = paginationService.fetchPage(pageableRequestDto);
        return page;
    }

    @Override
    public UniversityResponseDto update(Long id, UniversityRequestDto requestDto) {
        University university = universityRepository.fetchInstanceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("University", "id", String.valueOf(id)));
        University updatedUniversity = UniversityMapper.mapToEntity(requestDto, university);

        // mapping rector either he's been updated or not
        Teacher rector = teacherRepository.fetchInstanceById(requestDto.getRectorId())
                .orElseThrow(() -> new ResourceNotFoundException("Rector", "id", String.valueOf(requestDto.getRectorId())));
        updatedUniversity.setRector(rector);

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
