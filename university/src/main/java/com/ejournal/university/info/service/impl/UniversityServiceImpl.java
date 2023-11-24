package com.ejournal.university.info.service.impl;

import com.ejournal.university.common.dto.AddressDto;
import com.ejournal.university.info.dto.UniversityResponseDto;
import com.ejournal.university.info.dto.UniversityRequestDto;
import com.ejournal.university.info.service.UniversityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {

    private static final UniversityResponseDto UNIVERSITY = UniversityResponseDto.builder()
            .setUniversityName("Національний Авіаційний Університет")
            .setUniversityDescription("Національний авіаційний університет – один " +
                    "із найпотужніших авіаційних закладів вищої освіти у світі, в " +
                    "якому навчається близько 25 тисячі студентів, серед яких майже " +
                    "1500 іноземців з 55 країн світу. Ректор університету – доктор " +
                    "технічних наук, професор, Луцький Максим Георгійович")
            .setAddress(new AddressDto("Україна", "Київ", "пр. Гузара Любомира", "1", "03058"))
            .setEmail("post@nau.edu.ua")
            .setMobilePhone("(044) 406-79-01")
            .setAccreditation("4")
            .setRector(new UniversityResponseDto.RectorDto("Максим", "Луцький", "Георгійович"))
            .build();


    @Override
    public boolean create(UniversityRequestDto requestDto) {
        return false;
    }

    @Override
    public UniversityResponseDto fetchById(Long id) {
        return null;
    }

    @Override
    public List<UniversityResponseDto> fetchAll() {
        return null;
    }

    @Override
    public UniversityResponseDto update(UniversityRequestDto requestDto) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
