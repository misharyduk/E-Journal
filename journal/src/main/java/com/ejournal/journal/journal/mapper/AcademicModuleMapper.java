package com.ejournal.journal.journal.mapper;

import com.ejournal.journal.journal.dto.AcademicModuleRequestDto;
import com.ejournal.journal.journal.dto.AcademicModuleResponseDto;
import com.ejournal.journal.journal.entity.academic_entities.AcademicModule;

public class AcademicModuleMapper {

    public static AcademicModuleResponseDto mapToDto(AcademicModule academicModule){
        AcademicModuleResponseDto responseDto = new AcademicModuleResponseDto();
        responseDto.setId(academicModule.getId());
        responseDto.setModuleNumber(academicModule.getModuleNumber());
        return responseDto;
    }
}
