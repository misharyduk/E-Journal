package com.ejournal.university.info.service;

import com.ejournal.university.info.dto.UniversityResponseDto;
import com.ejournal.university.info.dto.UniversityRequestDto;

public interface UniversityService {

    boolean createUniversity(UniversityRequestDto universityRequestDto);

    UniversityResponseDto fetchUniversityDetails();

    UniversityResponseDto updateUniversityDetails(UniversityRequestDto universityRequestDto);

    boolean deleteUniversity();

}
