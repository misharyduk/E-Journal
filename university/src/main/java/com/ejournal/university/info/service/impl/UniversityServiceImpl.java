package com.ejournal.university.info.service.impl;

import com.ejournal.university.common.dto.AddressDto;
import com.ejournal.university.info.dto.UniversityDto;
import com.ejournal.university.info.service.UniversityService;
import org.springframework.stereotype.Service;

@Service
public class UniversityServiceImpl implements UniversityService {

    private static final UniversityDto UNIVERSITY = UniversityDto.builder()
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
            .setRector(new UniversityDto.RectorDto("Максим", "Луцький", "Георгійович"))
            .build();

    @Override
    public boolean createUniversity(UniversityDto universityRequestDto) {
        System.out.println("CREATE UNIVERSITY: " + universityRequestDto);
        return true;
    }

    @Override
    public UniversityDto fetchUniversityDetails() {
        return UNIVERSITY;
    }

    @Override
    public UniversityDto updateUniversityDetails(UniversityDto universityRequestDto) {
        System.out.println("UPDATE UNIVERSITY: " + universityRequestDto);
        return UNIVERSITY;
    }

    @Override
    public boolean deleteUniversity() {
        System.out.println("DELETE UNIVERSITY");
        return true;
    }
}
