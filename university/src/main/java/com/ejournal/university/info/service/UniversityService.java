package com.ejournal.university.info.service;

import com.ejournal.university.info.dto.UniversityDto;

public interface UniversityService {

    boolean createUniversity(UniversityDto universityRequestDto);

    UniversityDto fetchUniversityDetails();

    UniversityDto updateUniversityDetails(UniversityDto universityRequestDto);

    boolean deleteUniversity();

}
