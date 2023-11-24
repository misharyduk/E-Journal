package com.ejournal.university.info.service.impl;

import com.ejournal.university.info.dto.UniversityDto;
import com.ejournal.university.info.service.UniversityService;
import org.springframework.stereotype.Service;

@Service
public class UniversityServiceImpl implements UniversityService {

    private static final UniversityDto UNIVERSITY = new UniversityDto();

    @Override
    public boolean createUniversity(UniversityDto universityRequestDto) {
        return false;
    }

    @Override
    public UniversityDto fetchUniversityDetails() {
        return null;
    }

    @Override
    public UniversityDto updateUniversityDetails(UniversityDto universityRequestDto) {
        return null;
    }

    @Override
    public boolean deleteUniversity() {
        return false;
    }
}
