package com.ejournal.university.info.dto.builder;

import com.ejournal.university.common.dto.AddressDto;
import com.ejournal.university.common.dto.builder.Builder;
import com.ejournal.university.info.dto.UniversityResponseDto;
import com.ejournal.university.teacher.dto.TeacherResponseDto;

public class UniversityResponseBuilder implements Builder<UniversityResponseDto> {

    private Long universityId;
    private String universityName;
    private String universityDescription;
    private AddressDto address;
    private String mobilePhone;
    private String email;
    private String accreditation;
    private TeacherResponseDto rector;
    private Long numberOfFaculties;
    private Long numberOfDepartments;
    private Long numberOfTeachers;
    private Long numberOfStudents;

    private UniversityResponseBuilder() {
    }

    public static UniversityResponseBuilder getInstance() {
        return new UniversityResponseBuilder();
    }

    public UniversityResponseBuilder setUniversityId(Long universityId) {
        this.universityId = universityId;
        return this;
    }

    public UniversityResponseBuilder setUniversityName(String universityName) {
        this.universityName = universityName;
        return this;
    }

    public UniversityResponseBuilder setUniversityDescription(String universityDescription) {
        this.universityDescription = universityDescription;
        return this;
    }

    public UniversityResponseBuilder setAddress(AddressDto address) {
        this.address = address;
        return this;
    }

    public UniversityResponseBuilder setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public UniversityResponseBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UniversityResponseBuilder setAccreditation(String accreditation) {
        this.accreditation = accreditation;
        return this;
    }

    public UniversityResponseBuilder setRector(TeacherResponseDto rector) {
        this.rector = rector;
        return this;
    }

    public UniversityResponseBuilder setNumberOfFaculties(Long numberOfFaculties) {
        this.numberOfFaculties = numberOfFaculties;
        return this;
    }

    public UniversityResponseBuilder setNumberOfDepartments(Long numberOfDepartments) {
        this.numberOfDepartments = numberOfDepartments;
        return this;
    }

    public UniversityResponseBuilder setNumberOfTeachers(Long numberOfTeachers) {
        this.numberOfTeachers = numberOfTeachers;
        return this;
    }

    public UniversityResponseBuilder setNumberOfStudents(Long numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
        return this;
    }

    @Override
    public UniversityResponseDto build() {
        return new UniversityResponseDto(universityId, universityName, universityDescription,
                address, mobilePhone, email, accreditation, rector);
    }
}
