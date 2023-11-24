package com.ejournal.university.info.dto.builder;

import com.ejournal.university.common.dto.AddressDto;
import com.ejournal.university.common.dto.builder.Builder;
import com.ejournal.university.info.dto.UniversityResponseDto;

public class UniversityResponseBuilder implements Builder<UniversityResponseDto> {

    private String universityName;
    private String universityDescription;
    private AddressDto address;
    private String mobilePhone;
    private String email;
    private String accreditation;
    private UniversityResponseDto.RectorDto rector;

    private UniversityResponseBuilder() {
    }

    public static UniversityResponseBuilder getInstance() {
        return new UniversityResponseBuilder();
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

    public UniversityResponseBuilder setRector(UniversityResponseDto.RectorDto rector) {
        this.rector = rector;
        return this;
    }

    @Override
    public UniversityResponseDto build() {
        return new UniversityResponseDto(universityName, universityDescription,
                address, mobilePhone, email, accreditation, rector);
    }
}
